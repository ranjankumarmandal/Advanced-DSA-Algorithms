public class LongestIncreasingPathInAMatrix {
    private static final int[][] DIRECTIONS = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];

        int longestPath = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                longestPath = Math.max(longestPath, dfs(matrix, memo, row, col));
            }
        }

        return longestPath;
    }

    private int dfs(int[][] matrix, int[][] memo, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int longest = 1;

        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isValid(nextRow, nextCol, matrix)
                    && matrix[nextRow][nextCol] > matrix[row][col]) {
                longest = Math.max(longest, 1 + dfs(matrix, memo, nextRow, nextCol));
            }
        }

        return memo[row][col] = longest;
    }
}