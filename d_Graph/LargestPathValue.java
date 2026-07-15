public class LargestPathValue {
    private static final int INF = Integer.MAX_VALUE;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges)
            adj.get(e[0]).add(e[1]);

        int[][] count = new int[n][26];
        int[] vis = new int[n];
        int ans = 0;
    }
}