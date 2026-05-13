public class RaceCar {
    ublic int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int k = 32 - Integer.numberOfLeadingZeros(i);

            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }

            dp[i] = k + 1 + dp[(1 << k) - 1 - i];

            for (int j = 0; j < k - 1; j++) {
                int cur = (k - 1) + 1 + j + 1
                        + dp[i - ((1 << (k - 1)) - (1 << j))];

                dp[i] = Math.min(dp[i], cur);
            }
        }

        return dp[target];
    }
}