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

    }
}