public class RedundantConnection {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
    }
}