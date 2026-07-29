public class CountCompleteComponents {
    List<Integer>[] g;
    boolean[] vis;

    public int countCompleteComponents(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] res = dfs(i);
                int nodes = res[0];
                int degreeSum = res[1];
                if (degreeSum == nodes * (nodes - 1)) ans++;
            }
        }

        return ans;
    }

    int[] dfs(int u) {
        vis[u] = true;
        int nodes = 1;
        int degreeSum = g[u].size();

        for (int v : g[u]) {
            if (!vis[v]) {
                int[] t = dfs(v);
                nodes += t[0];
                degreeSum += t[1];
            }
        }

        return new int[]{nodes, degreeSum};
    }
}