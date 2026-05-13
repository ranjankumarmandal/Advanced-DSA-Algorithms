public class RaceCar {
    ublic int racecar(int target) {
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int k = 32 - Integer.numberOfLeadingZeros(i);

            if (i == (1 << k) - 1) {
                dp[i] = k;
                continue;
            }
        }

        return dp[target];
    }
}