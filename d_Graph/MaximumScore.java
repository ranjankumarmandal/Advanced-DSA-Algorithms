public class MaximumScore {
    public int maximumScore(int[] scores, int[][] edges) {
        int n = scores.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            graph[i].sort((a, b) -> scores[b] - scores[a]);
            if (graph[i].size() > 3) {
                graph[i] = new ArrayList<>(graph[i].subList(0, 3));
            }
        }

    }
}