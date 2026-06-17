public class MaxNumOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int i = 0;
        int day = 0;
        int ans = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] <= day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                ans++;
                day++;
            }
        }
    }
}