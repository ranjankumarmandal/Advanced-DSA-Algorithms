public class MinimumReorder {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : connections) {
            graph[e[0]].add(new int[]{e[1], 1});
            graph[e[1]].add(new int[]{e[0], 0});
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] v : graph[u]) {
                if (!vis[v[0]]) {
                    vis[v[0]] = true;
                    ans += v[1];
                    q.offer(v[0]);
                }
            }
        }

        return ans;
    }
}