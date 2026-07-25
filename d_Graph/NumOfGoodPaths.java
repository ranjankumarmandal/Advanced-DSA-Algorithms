public class NumOfGoodPaths {
    int[] parent;
    int[] size;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], Math.max(vals[e[0]], vals[e[1]])});
            graph[e[1]].add(new int[]{e[0], Math.max(vals[e[0]], vals[e[1]])});
        }
    }
}