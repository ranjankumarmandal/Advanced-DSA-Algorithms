public class CountRestrictedPath {
    public int countRestrictedPaths(int n, int[][] edges) {
        int rows=edges.length;
        int cols=edges[0].length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
    }
}