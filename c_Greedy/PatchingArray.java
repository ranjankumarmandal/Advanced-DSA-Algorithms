public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long reach = 1;
        int patches = 0;
        int i = 0;

        while (reach <= n) {
            if (i < nums.length && nums[i] <= reach) {
                reach += nums[i];
                i++;
            }
        }

        return patches;
    }
}