public class MinimumObstacles {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

    }
}