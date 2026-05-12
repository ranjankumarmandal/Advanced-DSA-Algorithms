public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int keep = 0;
        int swap = 1;

        for (int i = 1; i < n; i++) {
            int nextKeep = Integer.MAX_VALUE;
            int nextSwap = Integer.MAX_VALUE;

            keep = nextKeep;
            swap = nextSwap;
        }

        return Math.min(keep, swap);
    }
}