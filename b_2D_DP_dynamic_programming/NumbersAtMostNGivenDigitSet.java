public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int m = s.length();
        int d = digits.length;
        int ans = 0;

        for (int len = 1; len < m; len++) {
            ans += Math.pow(d, len);
        }

        for (int i = 0; i < m; i++) {
            boolean same = false;

            for (String digit : digits) {
                char c = digit.charAt(0);

                if (c < s.charAt(i)) {
                    ans += Math.pow(d, m - i - 1);
                } else if (c == s.charAt(i)) {
                    same = true;
                }
            }

            if (!same) {
                return ans;
            }
        }

        return ans + 1;
    }
}