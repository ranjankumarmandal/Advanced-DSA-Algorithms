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

        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;

            List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i] = 1;

            while (!q.isEmpty()) {
                int u = q.poll();
                comp.add(u);
                for (int v : graph[u]) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.offer(v);
                    } else if (color[v] == color[u]) {
                        return -1;
                    }
                }
            }

            int best = 0;
            for (int start : comp) {
                Arrays.fill(dist, -1);
                Queue<Integer> bfs = new LinkedList<>();
                bfs.offer(start);
                dist[start] = 1;
                int max = 1;

                while (!bfs.isEmpty()) {
                    int u = bfs.poll();
                    for (int v : graph[u]) {
                        if (dist[v] == -1) {
                            dist[v] = dist[u] + 1;
                            max = Math.max(max, dist[v]);
                            bfs.offer(v);
                        }
                    }
                }
                best = Math.max(best, max);
            }
            ans += best;
        }

        return ans;
    }
}
