public class AllPossibleFullBinaryTree {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            List<TreeNode> base = new ArrayList<>();
            base.add(new TreeNode(0));
            return base;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, res);
        return res;
    }
}