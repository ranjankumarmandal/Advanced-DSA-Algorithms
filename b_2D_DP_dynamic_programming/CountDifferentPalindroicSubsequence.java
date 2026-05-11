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

                    if (s.charAt(i) == c && s.charAt(j) == c) {
                        dp[i][j][k] = 2;
                        if (i + 1 <= j - 1) {
                            for (int t = 0; t < 4; t++) {
                                dp[i][j][k] += dp[i + 1][j - 1][t];
                            }
                        }
                    } else if (s.charAt(i) == c) {
                        dp[i][j][k] = dp[i][j - 1][k];
                    } else if (s.charAt(j) == c) {
                        dp[i][j][k] = dp[i + 1][j][k];
                    } else {
                        dp[i][j][k] = i + 1 <= j - 1 ? dp[i + 1][j - 1][k] : 0;
                    }

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