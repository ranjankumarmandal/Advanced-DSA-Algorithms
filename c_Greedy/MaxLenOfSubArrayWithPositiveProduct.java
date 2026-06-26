public class MaxLenOfSubArrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int pos = 0, neg = 0, ans = 0;

        for (int x : nums) {
            if (x == 0) {
                pos = 0;
                neg = 0;
            } else if (x > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg + 1;
            } else {
                int p = pos, n = neg;
                pos = n == 0 ? 0 : n + 1;
                neg = p + 1;
            }

            ans = Math.max(ans, pos);
        }
    }
}