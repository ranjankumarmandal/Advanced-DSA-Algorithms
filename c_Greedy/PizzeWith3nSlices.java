public class PizzeWith3nSlices {
    public int maxSizeSlices(int[] slices) {
        int m = slices.length / 3;
        return Math.max(calc(slices, 0, slices.length - 2, m),
                calc(slices, 1, slices.length - 1, m));
    }

    private int calc(int[] slices, int l, int r, int m) {
        int len = r - l + 1;
        int[][] dp = new int[len + 2][m + 1];

        for (int i = len - 1; i >= 0; i--) {
        }
    }
}