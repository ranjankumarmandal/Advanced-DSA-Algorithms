public class MaxNumOfNonOverlappingSubString {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left, n);
        Arrays.fill(right, -1);

    }
}