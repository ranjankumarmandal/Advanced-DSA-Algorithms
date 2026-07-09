public class MaximumNumEdgesToRemove {
    int[] parent;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parent[pa] = pb;
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int alice = 0, bob = 0, used = 0;

        for (int[] e : edges) {
            if (e[0] == 3) {
                if (union(e[1], e[2])) {
                    used++;
                    alice++;
                    bob++;
                }
            }
        }

        int[] save = parent.clone();

        for (int[] e : edges) {
            if (e[0] == 1 && union(e[1], e[2])) {
                used++;
                alice++;
            }
        }

        if (alice != n - 1) return -1;

        parent = save;
    }
}