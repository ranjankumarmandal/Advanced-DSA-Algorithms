public class MinDiffBtwnLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        java.util.Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;

        ans = Math.min(ans, nums[n - 4] - nums[0]);
        ans = Math.min(ans, nums[n - 3] - nums[1]);
        ans = Math.min(ans, nums[n - 2] - nums[2]);
    }
}