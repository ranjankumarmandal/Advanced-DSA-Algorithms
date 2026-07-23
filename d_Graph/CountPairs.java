public class CountPairs {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        long ans = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                long size = dfs(i, graph, vis);
                remaining -= size;
                ans += size * remaining;
            }
        }

        return ans;
    }

    private long dfs(int node, List<List<Integer>> graph, boolean[] vis) {
        vis[node] = true;
        long cnt = 1;

    }
}