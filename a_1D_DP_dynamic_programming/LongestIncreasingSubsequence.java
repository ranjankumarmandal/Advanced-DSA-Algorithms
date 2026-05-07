public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int num : nums) {
            int l = 0, r = len;

            while (l < r) {
                int m = l + (r - l) / 2;

                if (dp[m] < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }

            dp[l] = num;

            if (l == len) {
                len++;
            }
        }

        return len;
    }
}