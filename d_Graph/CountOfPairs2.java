public class CountOfPairs2 {
    public long[] countOfPairs(int n, int x, int y) {
        long[] ans = new long[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int d = Math.abs(i - j);
                d = Math.min(d, Math.abs(i - x) + 1 + Math.abs(y - j));
                d = Math.min(d, Math.abs(i - y) + 1 + Math.abs(x - j));
                ans[d - 1]++;
            }
        }

        return ans;
    }
}