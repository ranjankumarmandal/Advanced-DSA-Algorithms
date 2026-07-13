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
}