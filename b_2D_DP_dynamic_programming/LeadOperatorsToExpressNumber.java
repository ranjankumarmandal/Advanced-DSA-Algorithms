public class LeadOperatorsToExpressNumber {
    private Map<String, Integer> memo;

    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap<>();
        return dfs(x, target) - 1;
    }

    private int dfs(long x, long target) {
        if (target == 0) return 0;

        String key = x + "_" + target;
        if (memo.containsKey(key)) return memo.get(key);

        if (target < x) {
            int ops = (int) (2 * target);
            ops = Math.min(ops, (int) (2 * (x - target) + 1));
            memo.put(key, ops);
            return ops;
        }

        memo.put(key, ops);
        return ops;
    }
}