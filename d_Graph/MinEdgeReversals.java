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

    }
}