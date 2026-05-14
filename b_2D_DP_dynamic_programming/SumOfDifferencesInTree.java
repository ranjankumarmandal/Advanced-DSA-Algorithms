public class SumOfDifferencesInTree {
    private List<Integer>[] graph;
    private int[] count;
    private int[] ans;
    private int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        count = new int[n];
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs1(0, -1, 0);
        dfs2(0, -1);

        return ans;
    }

    private void dfs1(int node, int parent, int depth) {
        ans[0] += depth;
        count[node] = 1;

        for (int next : graph[node]) {
            if (next == parent) {
                continue;
            }

            dfs1(next, node, depth + 1);
            count[node] += count[next];
        }
    }
}