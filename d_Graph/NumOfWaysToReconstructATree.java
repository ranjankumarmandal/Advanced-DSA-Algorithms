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

        for (int node : graph.keySet()) {
            if (graph.get(node).size() == n - 1) {
                root = node;
                break;
            }
        }

        if (root == -1) {
            return 0;
        }

        int result = 1;

        for (int node : graph.keySet()) {
            if (node == root) {
                continue;
            }

            int parent = -1;
            int minDegree = Integer.MAX_VALUE;

            for (int nei : graph.get(node)) {
                int degree = graph.get(nei).size();
                if (degree >= graph.get(node).size() && degree < minDegree) {
                    parent = nei;
                    minDegree = degree;
                }
            }

            if (parent == -1) {
                return 0;
            }

    }
}