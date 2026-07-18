public class ProcessRequestedFriendRequest {
    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            int pu = dsu.find(u);
            int pv = dsu.find(v);
            boolean ok = true;

            if (pu != pv) {
                for (int[] r : restrictions) {
                    int a = dsu.find(r[0]);
                    int b = dsu.find(r[1]);
                    if ((a == pu && b == pv) || (a == pv && b == pu)) {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) {
                dsu.union(u, v);
                ans[i] = true;
            }
        }

        return ans;
    }
}