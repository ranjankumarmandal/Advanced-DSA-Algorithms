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

}