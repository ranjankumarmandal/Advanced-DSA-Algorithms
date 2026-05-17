public class ProfitableSchemes {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;

        for (int k = 0; k < group.length; k++) {
            int g = group[k];
            int p = profit[k];

            for (int members = n; members >= g; members--) {
                for (int prof = minProfit; prof >= 0; prof--) {
                    int np = Math.min(minProfit, prof + p);
                    dp[members][np] = (dp[members][np] + dp[members - g][prof]) % mod;
                }
            }
        }

        int ans = 0;

        return ans;
    }
}