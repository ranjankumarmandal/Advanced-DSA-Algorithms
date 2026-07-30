import java.util.*;

public class ModifyGraphEdgeWeights {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long inf = (long) 4e18;

        long d = dijkstra(n, edges, source, destination);
        if (d < target) return new int[0][];
        if (d == target) {
            for (int[] e : edges) {
                if (e[2] == -1) e[2] = 2000000000;
            }
            return edges;
        }

        boolean ok = false;

        for (int[] e : edges) {
            if (e[2] != -1) continue;

            if (ok) {
                e[2] = 2000000000;
                continue;
            }

            e[2] = 1;
            d = dijkstra(n, edges, source, destination);

            if (d <= target) {
                e[2] += target - d;
                ok = true;
            }
        }

        if (!ok) return new int[0][];

        for (int[] e : edges) {
            if (e[2] == -1) e[2] = 2000000000;
        }

        return edges;
    }

    private long dijkstra(int n, int[][] edges, int s, int t) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            if (e[2] == -1) continue;
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, s});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
    }
}