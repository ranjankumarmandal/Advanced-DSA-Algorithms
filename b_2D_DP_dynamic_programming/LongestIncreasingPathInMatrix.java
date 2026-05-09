public class LongestIncreasingPathInMatrix {
    private int[][] memo;
    private int[][] matrix;
    private int m, n;
    private final int[] dir = {0, 1, 0, -1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        memo = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        return ans;
    }

    private int dfs(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        int max = 1;

        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k];
            int nc = c + dir[k + 1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                    matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(nr, nc));
            }
        }

        return memo[r][c] = max;
    }
}