public class ParallelCourses2 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int m = 1 << n;
        int[] dp = new int[m];
        Arrays.fill(dp, n);
        dp[0] = 0;
    }
}