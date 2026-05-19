public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int x : rods) sum += x;

        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, -1);
        dp[0] = 0;

        return dp[0];
    }
}