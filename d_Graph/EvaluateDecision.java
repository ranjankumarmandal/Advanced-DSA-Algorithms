public class EvaluateDecision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Pair(b, val));
            graph.get(b).add(new Pair(a, 1.0 / val));
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dst = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dst)) {
                ans[i] = -1.0;
            } else if (src.equals(dst)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(src, dst, 1.0, new HashSet<>(), graph);
            }
        }

        return ans;
    }

    private double dfs(String curr, String target, double product, Set<String> vis,
                       Map<String, List<Pair>> graph) {
        if (curr.equals(target)) return product;

        vis.add(curr);

        for (Pair next : graph.get(curr)) {
            if (!vis.contains(next.node)) {
                double res = dfs(next.node, target, product * next.weight, vis, graph);
                if (res != -1.0) return res;
            }
        }

        return -1.0;
    }

    class Pair {
        String node;
        double weight;
    }
}