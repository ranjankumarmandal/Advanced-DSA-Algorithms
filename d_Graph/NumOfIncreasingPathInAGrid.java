public class NumOfIncreasingPathInAGrid {
    private static final int MOD = 1_000_000_007;
    private int[][] dp;
    private int[][] grid;
    private int m, n;
    private final int[] dr = {-1, 1, 0, 0};
    private final int[] dc = {0, 0, -1, 1};

    private int dfs(int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];

        long ans = 1;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > grid[r][c]) {
                ans += dfs(nr, nc);
                ans %= MOD;
            }
        }

        return dp[r][c] = (int) ans;
    }

    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += dfs(i, j);
                ans %= MOD;
            }
        }

        return (int) ans;
    }
}