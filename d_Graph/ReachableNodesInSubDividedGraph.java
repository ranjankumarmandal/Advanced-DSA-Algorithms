import java.util.*;

public class ReachableNodesInSubDividedGraph {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) continue;
            for (int[] next : graph[u]) {
                int v = next[0];
                int nd = d + next[1] + 1;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }

        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) ans++;
        }

        for (int[] e : edges) {
            int a = dist[e[0]] > maxMoves ? 0 : maxMoves - dist[e[0]];
            int b = dist[e[1]] > maxMoves ? 0 : maxMoves - dist[e[1]];
            ans += Math.min(e[2], a + b);
        }

        return ans;
    }
}