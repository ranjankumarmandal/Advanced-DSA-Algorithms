public class MaxLenOfSubArrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int pos = 0, neg = 0, ans = 0;

        for (int x : nums) {
            if (x == 0) {
                pos = 0;
                neg = 0;
            }
        }
    }
}