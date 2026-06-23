public class MinIntAfterMostKAdjacentSwapsOnDigits {
    static class Fenwick {
        int n;
        int[] bit;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            for (; idx <= n; idx += idx & -idx) bit[idx] += val;
        }

        int sum(int idx) {
            int res = 0;
            for (; idx > 0; idx -= idx & -idx) res += bit[idx];
            return res;
        }
    }

    public String minInteger(String num, int k) {}
}