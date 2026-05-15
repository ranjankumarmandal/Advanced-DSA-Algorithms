public class ValidPermutationOfDISequence {
    public int numPermsDISequence(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][] dp = new int [n+1][n+1];
        Arrays.fill(dp[0],1);

        f

        int ans = 0;
        for(int x:dp[n]){
            ans += x;
            ans %= mod;
        }

        return ans;
    }
}