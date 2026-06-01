public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int marker = digits.length;

        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i - 1] > digits[i]) {
            }
        }
    }
}