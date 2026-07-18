public class MaxPathQualityOfAGraph {
    private List<int[]>[] graph;
    private int[] values;
    private int[] seen;
    private int maxTime;
    private int ans;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        this.values = values;
        this.maxTime = maxTime;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        seen = new int[n];
        dfs(0, 0, 0);
        return ans;
    }
}