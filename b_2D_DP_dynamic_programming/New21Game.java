public class New21Game {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts - 1) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0;
        double result = 0.0;


        return result;
    }
}