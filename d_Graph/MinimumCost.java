public class MinimumCost {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

    }
}