public class MinCostToConvertString2 {
    static class Node {
        Node[] next = new Node[26];
        int id = -1;
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int m = original.length;
        Node root = new Node();
        int id = 0;

        for (String s : original) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int x = c - 'a';
                if (cur.next[x] == null) cur.next[x] = new Node();
                cur = cur.next[x];
            }
            if (cur.id == -1) cur.id = id++;
        }

        for (String s : changed) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int x = c - 'a';
                if (cur.next[x] == null) cur.next[x] = new Node();
                cur = cur.next[x];
            }
            if (cur.id == -1) cur.id = id++;
        }

        long INF = (long) 4e18;
        long[][] dist = new long[id][id];
        for (int i = 0; i < id; i++) {
            for (int j = 0; j < id; j++) dist[i][j] = i == j ? 0 : INF;
        }

        for (int i = 0; i < m; i++) {
            int u = getId(root, original[i]);
            int v = getId(root, changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < id; k++) {
            for (int i = 0; i < id; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < id; j++) {
                    if (dist[k][j] == INF) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int n = source.length();
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = INF;
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            Node a = root;
            Node b = root;
            for (int j = i; j < n; j++) {
                int x = source.charAt(j) - 'a';
                int y = target.charAt(j) - 'a';
                if (a != null) a = a.next[x];
                if (b != null) b = b.next[y];
                if (a == null || b == null) break;
                if (a.id != -1 && b.id != -1 && dist[a.id][b.id] != INF) {
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + dist[a.id][b.id]);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}