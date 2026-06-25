public class GetTheMaxScore {
    public int maxSum(int[] nums1, int[] nums2) {
        long mod = 1000000007L;
        int i = 0, j = 0;
        long s1 = 0, s2 = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                s1 += nums1[i++];
            }
        }
    }
}