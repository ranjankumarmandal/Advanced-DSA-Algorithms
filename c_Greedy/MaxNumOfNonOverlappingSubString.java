public class MaxNumOfNonOverlappingSubString {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left, n);
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            left[c] = Math.min(left[c], i);
            right[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (right[c] == -1) continue;

            int l = left[c];
            int r = right[c];
            boolean valid = true;

            for (int i = l; i <= r && valid; i++) {
                int ch = s.charAt(i) - 'a';

                if (left[ch] < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, right[ch]);
            }

            if (valid) intervals.add(new int[]{l, r});
        }
    }
}