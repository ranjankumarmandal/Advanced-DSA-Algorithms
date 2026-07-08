public class FindCriticalAndPseudoCriticalEdges {
    class DSU {
        int[] p, r;

        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            if (r[pa] < r[pb]) p[pa] = pb;
            else if (r[pa] > r[pb]) p[pb] = pa;
            else {
                p[pb] = pa;
                r[pa]++;
            }
            return true;
        }
    }

    int kruskal(int n, int[][] edges, int pick, int ban) {
        DSU dsu = new DSU(n);
        int cost = 0, cnt = 0;
        if (pick != -1) {
            dsu.union(edges[pick][0], edges[pick][1]);
            cost += edges[pick][2];
            cnt++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == ban) continue;
            if (dsu.union(edges[i][0], edges[i][1])) {
                cost += edges[i][2];
                cnt++;
            }
        }

        return cnt == n - 1 ? cost : Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int[][] e = new int[m][4];

    }
}