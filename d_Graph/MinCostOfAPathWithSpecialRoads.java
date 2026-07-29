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

    }
}