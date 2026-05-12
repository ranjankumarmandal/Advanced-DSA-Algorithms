public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int keep = 0;
        int swap = 1;

        for (int i = 1; i < n; i++) {
            int nextKeep = Integer.MAX_VALUE;
            int nextSwap = Integer.MAX_VALUE;

            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                nextKeep = Math.min(nextKeep, keep);
                nextSwap = Math.min(nextSwap, swap + 1);
            }

            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                nextKeep = Math.min(nextKeep, swap);
                nextSwap = Math.min(nextSwap, keep + 1);
            }

            keep = nextKeep;
            swap = nextSwap;
        }

        return Math.min(keep, swap);
    }
}