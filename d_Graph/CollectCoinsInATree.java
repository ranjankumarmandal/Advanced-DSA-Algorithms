import java.util.*;

public class CollectCoinsInATree {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        if (n == 1) return 0;

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int[] deg = new int[n];

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
            deg[u]++;
            deg[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1 && coins[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            deg[u]--;
            for (int v : g[u]) {
                if (deg[v] > 0) {
                    deg[v]--;
                    if (deg[v] == 1 && coins[v] == 0) q.offer(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) q.offer(i);
        }

        int[] time = new int[n];
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (deg[v] > 1) {
                    deg[v]--;
                    if (deg[v] == 1) {
                        time[v] = time[u] + 1;
                        q.offer(v);
                    }
                }
            }
        }

    }
}