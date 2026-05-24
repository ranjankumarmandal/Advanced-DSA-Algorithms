public class CreateMaxNumber {
    private int[] create(int[] a, int k) {
        int n = a.length;
        int[] st = new int[k];
        int top = 0;

        for (int i = 0; i < n; i++) {
            while (top > 0 && a[i] > st[top - 1] && n - i + top - 1 >= k) {
                top--;
            }
            if (top < k) {
                st[top++] = a[i];
            }
        }

        return st;
    }



    private int[] merge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int i = 0, j = 0, r = 0;
        while (i < n || j < m) {
            if (greater(a, i, b, j)) {
                res[r++] = a[i++];
            } else {
                res[r++] = b[j++];
            }
        }

        return res;
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[k];

        for (int i = Math.max(0, k - m); i <= Math.min(k, n); i++) {
            int[] x = create(nums1, i);
            int[] y = create(nums2, k - i);
            int[] v = merge(x, y);
            if (greater(v, 0, res, 0)) {
                res = v;
            }
        }

        return res;
    }
}