public class RankTransformOfAMatrix {
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

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.computeIfAbsent(matrix[i][j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int[] rowRank = new int[m];
        int[] colRank = new int[n];

        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> cells = entry.getValue();

            parent = new int[m + n];
            for (int i = 0; i < m + n; i++) {
                parent[i] = i;
            }

            for (int[] cell : cells) {
                union(cell[0], cell[1] + m);
            }

            Map<Integer, Integer> rank = new HashMap<>();

            for (int[] cell : cells) {
                int root = find(cell[0]);
                int value = Math.max(rowRank[cell[0]], colRank[cell[1]]);
                rank.put(root, Math.max(rank.getOrDefault(root, 0), value));
            }

            for (int[] cell : cells) {
                int root = find(cell[0]);
                int r = rank.get(root) + 1;
                ans[cell[0]][cell[1]] = r;
            }

            for (int[] cell : cells) {
                rowRank[cell[0]] = Math.max(rowRank[cell[0]], ans[cell[0]][cell[1]]);
                colRank[cell[1]] = Math.max(colRank[cell[1]], ans[cell[0]][cell[1]]);
            }
        }

        return ans;
    }
}