public class ValidArrangementOfPairs {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();

        for (int[] p : pairs) {
            graph.computeIfAbsent(p[0], k -> new ArrayDeque<>()).add(p[1]);
            out.put(p[0], out.getOrDefault(p[0], 0) + 1);
            in.put(p[1], in.getOrDefault(p[1], 0) + 1);
        }

        int start = pairs[0][0];
        for (int node : out.keySet()) {
            if (out.getOrDefault(node, 0) - in.getOrDefault(node, 0) == 1) {
                start = node;
                break;
            }
        }

        List<int[]> path = new ArrayList<>();
        dfs(start, graph, path);

        Collections.reverse(path);
        int[][] ans = new int[pairs.length][2];
        for (int i = 0; i < pairs.length; i++) {
            ans[i] = path.get(i);
        }
        return ans;
    }

    private void dfs(int u, Map<Integer, Deque<Integer>> graph, List<int[]> path) {
        Deque<Integer> next = graph.get(u);
        while (next != null && !next.isEmpty()) {
            int v = next.pollFirst();
            dfs(v, graph, path);
            path.add(new int[]{u, v});
        }
    }
}