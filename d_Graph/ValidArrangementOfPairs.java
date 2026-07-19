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

    }
}