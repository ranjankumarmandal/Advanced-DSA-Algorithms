public class DivideNodesIntoTheMaxNumOfGroups {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] color = new int[n + 1];
        int[] dist = new int[n + 1];
        int ans = 0;

    }
}
