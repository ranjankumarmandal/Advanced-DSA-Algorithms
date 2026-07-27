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

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int time = cur[2];

            if (r == m - 1 && c == n - 1) {
                return time;
            }

            if (time > dist[r][c]) {
                continue;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int nextTime = time + 1;

                if (nextTime < grid[nr][nc]) {
                    int diff = grid[nr][nc] - nextTime;
                    if (diff % 2 == 0) {
                        nextTime = grid[nr][nc];
                    } else {
                        nextTime = grid[nr][nc] + 1;
                    }
                }

                if (nextTime < dist[nr][nc]) {
                    dist[nr][nc] = nextTime;
                    pq.offer(new int[]{nr, nc, nextTime});
                }
            }
        }

        return -1;
    }
}