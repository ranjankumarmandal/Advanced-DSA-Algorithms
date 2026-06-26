public class MinNumOfFuncCallsToMakeTargetArray {
    public int minOperations(int[] nums) {
        int add = 0, dbl = 0;

        for (int x : nums) {
            int bits = Integer.bitCount(x);
            add += bits;
            int shifts = 0;
            while (x > 1) {
                x >>= 1;
                shifts++;
            }
        }
    }
}