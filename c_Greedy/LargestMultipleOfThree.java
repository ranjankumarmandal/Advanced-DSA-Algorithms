public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int[] cnt = new int[10];
        int sum = 0;
        for (int d : digits) {
            cnt[d]++;
            sum += d;
        }

        int mod = sum % 3;

        if (mod == 1) {
            if (!remove(cnt, new int[]{1, 4, 7}, 1)) {
                remove(cnt, new int[]{2, 5, 8}, 2);
            }
        } else if (mod == 2) {
            if (!remove(cnt, new int[]{2, 5, 8}, 1)) {
                remove(cnt, new int[]{1, 4, 7}, 2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d = 9; d >= 0; d--) {
            while (cnt[d]-- > 0) {
                sb.append(d);
            }
        }

        if (sb.length() == 0) return "";
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }

    private boolean remove(int[] cnt, int[] digits, int times) {
    }
}