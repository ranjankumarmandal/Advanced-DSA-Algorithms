public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph, path, ans);
        return ans;
    }

    private void dfs(int node, int[][] graph, List<Integer> path, List<List<Integer>> ans) {
    }
}