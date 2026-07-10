public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] minDist = new int[n];
        boolean[] vis = new boolean[n];
        java.util.Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }

            vis[u] = true;
            ans += minDist[u];

        }
    }
}