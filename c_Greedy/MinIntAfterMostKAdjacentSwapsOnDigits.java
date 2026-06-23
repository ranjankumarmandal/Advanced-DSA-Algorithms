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

    public String minInteger(String num, int k) {
        int n = num.length();
        java.util.ArrayDeque<Integer>[] pos = new java.util.ArrayDeque[10];
        for (int i = 0; i < 10; i++) pos[i] = new java.util.ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'].offer(i + 1);
        }

        Fenwick bit = new Fenwick(n);
        StringBuilder ans = new StringBuilder();

    }
}