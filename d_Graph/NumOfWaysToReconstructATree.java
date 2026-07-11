public class NumOfWaysToReconstructATree {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        int n = graph.size();
        int root = -1;

    }
}