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

        char replaceMin = 0;
        char targetMin = '0';

        if (s.charAt(0) != '1') {
            replaceMin = s.charAt(0);
            targetMin = '1';
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    replaceMin = s.charAt(i);
                    break;
                }
            }
        }

        String minStr = s;
        if (replaceMin != 0) {
            minStr = s.replace(replaceMin, targetMin);
        }
    }
}