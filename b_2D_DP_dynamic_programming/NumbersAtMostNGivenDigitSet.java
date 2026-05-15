public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int m = s.length();
        int d = digits.length;
        int ans = 0;

        for (int len = 1; len < m; len++) {
            ans += Math.pow(d, len);
        }



        return ans + 1;
    }
}