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


    }
}