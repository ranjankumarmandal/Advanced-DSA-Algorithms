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
        int[]dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[n]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{n,0});
        while(!pq.isEmpty()){
            int[]curr=pq.poll();
            int d=curr[1];
            int u=curr[0];
            if(d>dist[u]) continue;
            for(int []neigh:adj.get(u)){
                int v=neigh[0];
                int weight=neigh[1];
                if(dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);

        return dfs(1,n,adj,dist,dp);
    }

    private int dfs(int u,int n,List<List<int[]>>adj,int[]dist,int[]dp){
        if(u==n) return 1;
        if(dp[u]!=-1) return dp[u];
        long totalWays=0;
        for(int []neigh:adj.get(u)){
            int v=neigh[0];
            if(dist[u]>dist[v]) {
                totalWays=(totalWays+dfs(v,n,adj,dist,dp)) % 1000000007;
            }
        }

        return dp[u]=(int)totalWays;
    }
}