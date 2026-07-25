public class NumOfGoodPaths {
    int[] parent;
    int[] size;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], Math.max(vals[e[0]], vals[e[1]])});
            graph[e[1]].add(new int[]{e[0], Math.max(vals[e[0]], vals[e[1]])});
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(vals[i], k -> new ArrayList<>()).add(i);
        }

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int ans = 0;

        for (int val : map.keySet()) {
            for (int node : map.get(val)) {
                for (int[] nei : graph[node]) {
                    if (nei[1] <= val) {
                        union(node, nei[0]);
                    }
                }
            }

            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (int node : map.get(val)) {
                int root = find(node);
                cnt.put(root, cnt.getOrDefault(root, 0) + 1);
            }

            for (int c : cnt.values()) {
                ans += c * (c + 1) / 2;
            }
        }

        return ans;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}