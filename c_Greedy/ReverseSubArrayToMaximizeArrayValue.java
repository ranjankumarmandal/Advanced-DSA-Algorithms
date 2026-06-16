public class ReverseSubArrayToMaximizeArrayValue {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int base = 0;

        for (int i = 0; i < n - 1; i++) {
            base += Math.abs(nums[i] - nums[i + 1]);
        }

        int gain = 0;
        int minHigh = Integer.MAX_VALUE;
        int maxLow = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
        }
    }
}