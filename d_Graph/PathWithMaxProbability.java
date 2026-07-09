public class PathWithMaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph[u].add(new int[]{v, i});
            graph[v].add(new int[]{u, i});
        }

        double[] prob = new double[n];
        prob[start] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            int u = (int) cur[0];
            double p = cur[1];

            if (u == end) return p;
            if (p < prob[u]) continue;

            for (int[] next : graph[u]) {
                int v = next[0];
                double np = p * succProb[next[1]];
                if (np > prob[v]) {
                    prob[v] = np;
                    pq.offer(new double[]{v, np});
                }
            }
        }
    }
}