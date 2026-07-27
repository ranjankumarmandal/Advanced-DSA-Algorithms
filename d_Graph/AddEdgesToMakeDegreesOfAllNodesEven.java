public class AddEdgesToMakeDegreesOfAllNodesEven {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Set<String> set = new HashSet<>();

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            graph[u].add(v);
            graph[v].add(u);
            set.add(u + "#" + v);
            set.add(v + "#" + u);
        }

        List<Integer> odd = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (graph[i].size() % 2 == 1) {
                odd.add(i);
            }
        }

        if (odd.size() == 0) {
            return true;
        }

        if (odd.size() != 2 && odd.size() != 4) {
            return false;
        }

        if (odd.size() == 2) {
            int a = odd.get(0);
            int b = odd.get(1);

            if (!set.contains(a + "#" + b)) {
                return true;
            }

            for (int i = 1; i <= n; i++) {
                if (i != a && i != b &&
                        !set.contains(a + "#" + i) &&
                        !set.contains(b + "#" + i)) {
                    return true;
                }
            }

            return false;
        }

        int a = odd.get(0);
        int b = odd.get(1);
        int c = odd.get(2);
        int d = odd.get(3);

        if (check(a, b, c, d, set) ||
                check(a, c, b, d, set) ||
                check(a, d, b, c, set)) {
            return true;
        }

        return false;
    }
}