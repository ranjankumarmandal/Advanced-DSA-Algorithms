public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int a = -1, b = -1, ans = 0;

        for (int[] in : intervals) {
            int l = in[0], r = in[1];


        }

        return ans;
    }
}