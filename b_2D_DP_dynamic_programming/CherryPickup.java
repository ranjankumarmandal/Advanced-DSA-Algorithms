public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = grid[0][0];

        for (int k = 1; k <= 2 * n - 2; k++) {

            int[][] newDp = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(newDp[i], Integer.MIN_VALUE);
            }

            for (int r1 = 0; r1 < n; r1++) {
                for (int r2 = 0; r2 < n; r2++) {

                    int c1 = k - r1;
                    int c2 = k - r2;

                    if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) {
                        continue;
                    }

                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }

                    int bestPrev = dp[r1][r2];

                    if (r1 > 0) {
                        bestPrev = Math.max(bestPrev, dp[r1 - 1][r2]);
                    }

                    if (r2 > 0) {
                        bestPrev = Math.max(bestPrev, dp[r1][r2 - 1]);
                    }

                    if (r1 > 0 && r2 > 0) {
                        bestPrev = Math.max(bestPrev, dp[r1 - 1][r2 - 1]);
                    }

                    if (bestPrev == Integer.MIN_VALUE) {
                        continue;
                    }

                    int cherries = grid[r1][c1];

                    if (r1 != r2) {
                        cherries += grid[r2][c2];
                    }

                    newDp[r1][r2] = bestPrev + cherries;
                }
            }

            dp = newDp;
        }

        return Math.max(0, dp[n - 1][n - 1]);
    }
}