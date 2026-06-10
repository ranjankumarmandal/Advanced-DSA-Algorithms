public class SplitArrayLargestSum {
    int[] nums;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int low = 0, high = 0, min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        return min;
    }
}