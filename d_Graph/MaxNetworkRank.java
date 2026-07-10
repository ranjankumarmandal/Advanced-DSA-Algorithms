public class MaxNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for (int[] road : roads) {
            int u = road[0], v = road[1];
            degree[u]++;
            degree[v]++;
            connected[u][v] = true;
            connected[v][u] = true;
        }

    }
}