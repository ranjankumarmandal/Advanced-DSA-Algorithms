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

        long sum = x;
        int power = 0;
        while (sum <= target) {
            sum *= x;
            power++;
        }
        sum /= x;

        int ops = power + dfs(x, target - sum);

        if (sum * x - target < target) {
            ops = Math.min(ops, power + 1 + dfs(x, sum * x - target));
        }

        memo.put(key, ops);
        return ops;
    }
}