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
    }
}