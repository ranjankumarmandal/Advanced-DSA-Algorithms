public class MinFuelCostToReportToTheCapital {
    private long ans;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : roads) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        dfs(0, -1, graph, seats);

        return ans;
    }

    private int dfs(int node, int parent, List<Integer>[] graph, int seats) {
        int people = 1;
        for (int next : graph[node]) {
            if (next != parent) {
                people += dfs(next, node, graph, seats);
            }
        }
        if (node != 0) {
            ans += (people + seats - 1) / seats;
        }

        return people;
    }
}
