import java.util.*;

public class NumOfWaysToArriveAtDestination {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<long[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new long[]{r[1], r[2]});
            graph[r[1]].add(new long[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        long[] ways = new long[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

    }
}