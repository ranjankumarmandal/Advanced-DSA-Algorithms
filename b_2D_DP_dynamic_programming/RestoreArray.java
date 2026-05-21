public class RestoreArray {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;

            long num = 0;

        }

        return (int) dp[0];
    }
}