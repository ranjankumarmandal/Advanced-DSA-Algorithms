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
    }
}