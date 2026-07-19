public class DetonateTheMaxBombs {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long x1 = bombs[i][0], y1 = bombs[i][1], r = bombs[i][2];
            long rr = r * r;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                long dx = x1 - bombs[j][0];
                long dy = y1 - bombs[j][1];
                if (dx * dx + dy * dy <= rr) {
                    graph[i].add(j);
                }
            }
        }

    }
}