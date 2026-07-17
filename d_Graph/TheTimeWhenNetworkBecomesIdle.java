import java.util.*;

public class TheTimeWhenNetworkBecomesIdle {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            int roundTrip = dist[i] * 2;
            int lastSend;
            if (patience[i] >= roundTrip) {
                lastSend = 0;
            } else {
                lastSend = ((roundTrip - 1) / patience[i]) * patience[i];
            }
            ans = Math.max(ans, lastSend + roundTrip);
        }
    }
}