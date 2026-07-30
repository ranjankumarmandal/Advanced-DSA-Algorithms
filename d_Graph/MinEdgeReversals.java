public class MinEdgeReversals {
    List<int[]>[] g;
    int[] ans;

    public int[] minEdgeReversals(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], 0});
            g[e[1]].add(new int[]{e[0], 1});
        }

        ans = new int[n];
        ans[0] = dfs0(0, -1);
        dfs1(0, -1);

        return ans;
    }

    int dfs0(int u, int p) {
        int res = 0;
        for (int[] e : g[u]) {
            int v = e[0];
            if (v == p) continue;
            res += e[1] + dfs0(v, u);
        }
        return res;
    }

    void dfs1(int u, int p) {
        }
    }
}