public class FindingSmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] in = new boolean[n];
        for (List<Integer> e : edges) {
            in[e.get(1)] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!in[i]) ans.add(i);
        }
    }
}