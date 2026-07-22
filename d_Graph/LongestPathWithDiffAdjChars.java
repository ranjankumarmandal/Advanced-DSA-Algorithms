public class LongestPathWithDiffAdjChars {
    private int ans = 1;

    private int dfs(int node, List<List<Integer>> tree, String s) {
        int longest = 0;
        int secondLongest = 0;

        for (int child : tree.get(node)) {
            int len = dfs(child, tree, s);

            if (s.charAt(child) == s.charAt(node)) continue;

            if (len > longest) {
                secondLongest = longest;
                longest = len;
            } else if (len > secondLongest) {
                secondLongest = len;
            }
        }

        ans = Math.max(ans, longest + secondLongest + 1);
        return longest + 1;
    }

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> tree = new ArrayList<>();
    }
}