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
        for (int mask = 0; mask < m; mask++) {
            int avail = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && (pre[i] & mask) == pre[i]) {
                    avail |= 1 << i;
                }
            }
            if (Integer.bitCount(avail) <= k) {
                dp[mask | avail] = Math.min(dp[mask | avail], dp[mask] + 1);
            } else {
                for (int sub = avail; sub > 0; sub = (sub - 1) & avail) {
                    if (Integer.bitCount(sub) == k) {
                        dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + 1);
                    }
                }
            }
        }
    }
}