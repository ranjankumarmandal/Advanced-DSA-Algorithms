public class StrangePrinter2 {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int max = 60;
        int[] minR = new int[max + 1];
        int[] maxR = new int[max + 1];
        int[] minC = new int[max + 1];
        int[] maxC = new int[max + 1];
        boolean[] exists = new boolean[max + 1];

        for (int i = 1; i <= max; i++) {
            minR[i] = minC[i] = Integer.MAX_VALUE;
            maxR[i] = maxC[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                exists[c] = true;
                minR[c] = Math.min(minR[c], i);
                maxR[c] = Math.max(maxR[c], i);
                minC[c] = Math.min(minC[c], j);
                maxC[c] = Math.max(maxC[c], j);
            }
        }

        boolean[][] graph = new boolean[max + 1][max + 1];
        int[] indegree = new int[max + 1];

        for (int c = 1; c <= max; c++) {
            if (!exists[c]) continue;
            for (int i = minR[c]; i <= maxR[c]; i++) {
                for (int j = minC[c]; j <= maxC[c]; j++) {
                    int d = targetGrid[i][j];
                    if (d != c && !graph[c][d]) {
                        graph[c][d] = true;
                        indegree[d]++;
                    }
                }
            }
        }

        java.util.Queue<Integer> q = new java.util.ArrayDeque<>();
        int total = 0;
        for (int i = 1; i <= max; i++) {
            if (exists[i]) {
                total++;
                if (indegree[i] == 0) q.offer(i);
            }
        }

    }
}