public class MinimumWeight {
    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    private long[] dijkstra(List<List<Pair>> graph, int src) {
        int n = graph.size();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        dist[src] = 0;
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.dist != dist[cur.node]) continue;

            for (Pair next : graph.get(cur.node)) {
                if (dist[next.node] > cur.dist + next.dist) {
                    dist[next.node] = cur.dist + next.dist;
                    pq.offer(new Pair(next.node, dist[next.node]));
                }
            }
        }
        return dist;
    }

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<Pair>> graph = new ArrayList<>();
        List<List<Pair>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new Pair(e[1], e[2]));
            rev.get(e[1]).add(new Pair(e[0], e[2]));
        }

        long[] d1 = dijkstra(graph, src1);
        long[] d2 = dijkstra(graph, src2);
        long[] d3 = dijkstra(rev, dest);

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (d1[i] == Long.MAX_VALUE || d2[i] == Long.MAX_VALUE || d3[i] == Long.MAX_VALUE)
                continue;
            ans = Math.min(ans, d1[i] + d2[i] + d3[i]);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}