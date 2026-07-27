public class AddEdgesToMakeDegreesOfAllNodesEven {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Set<String> set = new HashSet<>();

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            graph[u].add(v);
            graph[v].add(u);
            set.add(u + "#" + v);
            set.add(v + "#" + u);
        }

    }
}