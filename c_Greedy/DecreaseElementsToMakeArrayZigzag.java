public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        long[] cost = new long[2];

        for (int i = 0; i < n; i++) {
            int limit = Integer.MAX_VALUE;
            if (i > 0) limit = Math.min(limit, nums[i - 1]);
            if (i + 1 < n) limit = Math.min(limit, nums[i + 1]);

            int need = Math.max(0, nums[i] - limit + 1);
            cost[i & 1] += need;
        }

        return (int) Math.min(cost[0], cost[1]);
    }
}