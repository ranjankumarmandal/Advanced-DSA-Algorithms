public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int x : rods) sum += x;

        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int r : rods) {
            int[] cur = dp.clone();

            for (int d = 0; d <= sum - r; d++) {
                if (cur[d] < 0) continue;

                dp[d + r] = Math.max(dp[d + r], cur[d]);

                int nd = Math.abs(d - r);
                dp[nd] = Math.max(dp[nd], cur[d] + Math.min(d, r));
            }
        }

        return dp[0];
    }
}