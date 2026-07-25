public class MostProfitablePathInATree {
    List<Integer>[] graph;
    int[] parent;
    int[] depth;
    int[] bobTime;
    int[] amount;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        Arrays.fill(parent, -1);

        dfsParent(0, -1, 0);

        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);

        int t = 0;
        int cur = bob;
        while (cur != -1) {
            bobTime[cur] = t++;
            cur = parent[cur];
        }

        dfsAlice(0, -1, 0, 0);

        return ans;
    }

    void dfsParent(int node, int par, int d) {
        parent[node] = par;
        depth[node] = d;
        for (int nei : graph[node]) {
            if (nei != par) {
                dfsParent(nei, node, d + 1);
            }
        }
    }

    void dfsAlice(int node, int par, int time, int profit) {
        if (time < bobTime[node]) {
            profit += amount[node];
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2;
        }

        boolean leaf = true;

        for (int nei : graph[node]) {
            if (nei != par) {
                leaf = false;
                dfsAlice(nei, node, time + 1, profit);
            }
        }

        if (leaf) {
            ans = Math.max(ans, profit);
        }
    }
}