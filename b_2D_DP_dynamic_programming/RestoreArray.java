public class RestoreArray {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[n] = 1;



        return (int) dp[0];
    }
}