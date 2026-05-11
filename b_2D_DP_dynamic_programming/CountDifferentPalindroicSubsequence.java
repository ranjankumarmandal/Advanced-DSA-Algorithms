public class CountDifferentPalindroicSubsequence {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = 1000000007;
        long[][][] dp = new long[n][n][4];

        for (int i = 0; i < n; i++) {
            dp[i][i][s.charAt(i) - 'a'] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                for (int k = 0; k < 4; k++) {
                    char c = (char) ('a' + k);

                    dp[i][j][k] %= mod;
                }
            }
        }

        long ans = 0;

        for (int k = 0; k < 4; k++) {
            ans += dp[0][n - 1][k];
        }

        return (int) (ans % mod);
    }
}