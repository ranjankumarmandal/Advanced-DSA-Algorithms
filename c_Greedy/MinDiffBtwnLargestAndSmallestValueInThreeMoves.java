public class MinDiffBtwnLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if (n <= 4) return 0;

        java.util.Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;

    }
}