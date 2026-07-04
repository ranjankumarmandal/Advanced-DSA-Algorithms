import java.util.*;

public class CriticalConnectionsInANetwork {
    int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (List<Integer> e : connections) {
            graph.get(e.get(0)).add(e.get(1));
            graph.get(e.get(1)).add(e.get(0));
        }

        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);

        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, graph, disc, low, res);
        return res;
    }

    void dfs(int u, int parent, List<List<Integer>> graph, int[] disc, int[] low, List<List<Integer>> res) {
        disc[u] = low[u] = time++;
    }
}