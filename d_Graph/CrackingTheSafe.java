public class CrackingTheSafe {
    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        StringBuilder ans = new StringBuilder();
        HashSet<String> seen = new HashSet<>();
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < n - 1; i++) start.append('0');
        dfs(start.toString(), k, seen, ans);
        ans.append(start);

        return ans.toString();
    }

    private void dfs(String node, int k, HashSet<String> seen, StringBuilder ans) {
        for (int i = 0; i < k; i++) {
            String edge = node + i;
            if (!seen.contains(edge)) {
                seen.add(edge);
                dfs(edge.substring(1), k, seen, ans);
                ans.append(i);
            }
        }
    }
}