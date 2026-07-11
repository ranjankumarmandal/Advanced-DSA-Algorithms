public class CheckingExistenceOfEdgeLengthLimitedPaths {
    int[] parent;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parent[pb] = pa;
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        int m = queries.length;
        int[][] q = new int[m][4];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = queries[i][2];
            q[i][3] = i;
        }

        Arrays.sort(q, (a, b) -> a[2] - b[2]);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] ans = new boolean[m];
        int idx = 0;

    }
}