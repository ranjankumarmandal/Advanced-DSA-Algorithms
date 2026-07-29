public class MinCostOfAPathWithSpecialRoads {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        for (int i = 0; i < n; i++) {
            dist[i] = manhattan(start[0], start[1], specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4];
            pq.offer(new long[]{dist[i], i});
        }

        long ans = manhattan(start[0], start[1], target[0], target[1]);

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int i = (int) cur[1];
            if (d != dist[i]) continue;

            ans = Math.min(ans,
                    d + manhattan(specialRoads[i][2], specialRoads[i][3], target[0], target[1]));

            for (int j = 0; j < n; j++) {
                long nd = d
                        + manhattan(specialRoads[i][2], specialRoads[i][3],
                        specialRoads[j][0], specialRoads[j][1])
                        + specialRoads[j][4];
                if (nd < dist[j]) {
                    dist[j] = nd;
                    pq.offer(new long[]{nd, j});
                }
            }
        }
    }
}