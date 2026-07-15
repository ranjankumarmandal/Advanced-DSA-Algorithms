public class CountRestrictedPath {
    public int countRestrictedPaths(int n, int[][] edges) {
        int rows=edges.length;
        int cols=edges[0].length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
    }
}