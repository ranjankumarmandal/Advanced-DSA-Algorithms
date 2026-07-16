import java.util.*;

public class MinCostToReachDestinationInTime {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[][] dist = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0][0] = passingFees[0];
        pq.offer(new int[]{passingFees[0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], time = cur[2];

            if (u == n - 1) return cost;
            if (cost != dist[u][time]) continue;

            for (int[] next : graph[u]) {
                int v = next[0];
                int t = time + next[1];
                if (t > maxTime) continue;
                int nc = cost + passingFees[v];
                if (nc < dist[v][t]) {
                    dist[v][t] = nc;
                    pq.offer(new int[]{nc, v, t});
                }
            }
        }
    }
}