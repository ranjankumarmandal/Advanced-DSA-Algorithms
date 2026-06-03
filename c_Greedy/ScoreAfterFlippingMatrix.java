public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int j = 0; j < n; j++) {
            int ones = 0;

            for (int i = 0; i < m; i++) {
                if (grid[i][0] == 1) {
                    ones += grid[i][j];
                } else {
                    ones += 1 - grid[i][j];
                }
            }

            ones = Math.max(ones, m - ones);
            ans += ones * (1 << (n - 1 - j));
        }

        return ans;
    }
}