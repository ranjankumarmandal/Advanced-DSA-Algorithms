import java.util.*;

public class NumberOfSets {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        int total = 1 << n;
        long inf = (long) 1e15;

        for (int mask = 0; mask < total; mask++) {
            long[][] dist = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], inf);
                dist[i][i] = 0;
            }

            for (int[] r : roads) {
                int u = r[0], v = r[1], w = r[2];
                if (((mask >> u) & 1) == 0 && ((mask >> v) & 1) == 0) {
                    dist[u][v] = Math.min(dist[u][v], w);
                    dist[v][u] = Math.min(dist[v][u], w);
                }
            }

            for (int k = 0; k < n; k++) {
                if (((mask >> k) & 1) == 1) continue;
                for (int i = 0; i < n; i++) {
                    if (((mask >> i) & 1) == 1) continue;
                    for (int j = 0; j < n; j++) {
                        if (((mask >> j) & 1) == 1) continue;
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
    }
}