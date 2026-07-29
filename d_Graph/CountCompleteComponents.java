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

    }
}