public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        Double[][] dp = new Double[n][k];
        return divide(nums, 0, n, k-1, dp);
    }

    public double divide(int[] nums, int start, int end, int k, Double[][] dp) {
        if(start >= end) return 0;
        if(dp[start][k] != null) return dp[start][k];
        if(k == 0) {
            double lastPartitionSum = 0;
            for(int j = start; j < end; j++) {
                lastPartitionSum += nums[j];
            }
            return lastPartitionSum / (end - start);
        }



        return max;
    }
}