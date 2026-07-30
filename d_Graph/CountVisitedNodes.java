import java.util.*;

public class CountVisitedNodes {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indeg = new int[n];

        for (int v : edges) indeg[v]++;

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        boolean[] removed = new boolean[n];

        while (!q.isEmpty()) {
            int u = q.poll();
            removed[u] = true;
            int v = edges.get(u);
            if (--indeg[v] == 0) q.offer(v);
        }

        int[] ans = new int[n];
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!removed[i] && !vis[i]) {
                int cur = i;
                int len = 0;
                do {
                    vis[cur] = true;
                    len++;
                    cur = edges.get(cur);
                } while (cur != i);

                cur = i;
                do {
                    ans[cur] = len;
                    cur = edges.get(cur);
                } while (cur != i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (removed[i] && ans[i] == 0) dfs(i, edges, ans);
        }

        return ans;
    }

    int dfs(int u, List<Integer> edges, int[] ans) {
        if (ans[u] != 0) return ans[u];
        ans[u] = 1 + dfs(edges.get(u), edges, ans);
        return ans[u];
    }
}