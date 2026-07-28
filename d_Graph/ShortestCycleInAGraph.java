public class ShortestCycleInAGraph {
    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = Integer.MAX_VALUE;

        for (int s = 0; s < n; s++) {
            int[] dist = new int[n];
            int[] parent = new int[n];
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            dist[s] = 0;

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        parent[v] = u;
                        q.offer(v);
                    } else if (parent[u] != v) {
                        ans = Math.min(ans, dist[u] + dist[v] + 1);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}