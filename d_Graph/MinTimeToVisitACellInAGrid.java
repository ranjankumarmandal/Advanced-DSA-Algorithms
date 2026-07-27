import java.util.*;

public class MinTimeToVisitACellInAGrid {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return 0;
        }

        if ((m > 1 && grid[1][0] > 1) && (n > 1 && grid[0][1] > 1)) {
            return -1;
        }

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

    }
}