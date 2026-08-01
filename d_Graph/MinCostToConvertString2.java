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

    }
}