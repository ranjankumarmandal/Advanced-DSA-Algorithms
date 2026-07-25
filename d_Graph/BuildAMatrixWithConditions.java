public class BuildAMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topoSort(k, rowConditions);
        if (rowOrder == null) return new int[0][0];

        int[] colOrder = topoSort(k, colConditions);
        if (colOrder == null) return new int[0][0];

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowPos[rowOrder[i]] = i;
            colPos[colOrder[i]] = i;
        }

        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            ans[rowPos[i]][colPos[i]] = i;
        }

        return ans;
    }

    private int[] topoSort(int k, int[][] edges) {
        List<Integer>[] graph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++) graph[i] = new ArrayList<>();

        int[] indegree = new int[k + 1];
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            indegree[e[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] order = new int[k];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : graph[u]) {
                if (--indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return idx == k ? order : null;
    }
}