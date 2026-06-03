public class MinNumOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long fuel = startFuel;
        int prev = 0;
        int stops = 0;

        for (int i = 0; i <= stations.length; i++) {
            int pos = i == stations.length ? target : stations[i][0];
            fuel -= pos - prev;

            prev = pos;
        }

        return stops;
    }
}