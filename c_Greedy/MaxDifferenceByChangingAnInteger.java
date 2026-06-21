public class MaxDifferenceByChangingAnInteger {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        char replaceMax = 0;
        for (char c : s.toCharArray()) {
            if (c != '9') {
                replaceMax = c;
                break;
            }
        }

        String maxStr = s;
        if (replaceMax != 0) {
            maxStr = s.replace(replaceMax, '9');
        }
    }
}