public class FrogPositionAfteTSeconds {
    List<Integer>[] graph;
    boolean[] vis;
    int target;
    int limit;
    double ans;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        this.target = target;
        this.limit = t;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        vis = new boolean[n + 1];
        dfs(1, 0, 1.0);
        return ans;
    }

    void dfs(int node, int time, double prob) {
        vis[node] = true;
        int children = 0;
        for (int nei : graph[node]) {
            if (!vis[nei]) children++;
        }

        if (node == target) {
            if (time == limit || children == 0) ans = prob;
            vis[node] = false;
            return;
        }

        if (time == limit) {
            return;
        }

        for (int nei : graph[node]) {
            if (!vis[nei]) {
                dfs(nei, time + 1, prob / children);
            }
        }
        vis[node] = false;
    }
}