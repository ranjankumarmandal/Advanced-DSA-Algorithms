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

    }

    public String minInteger(String num, int k) {}
}