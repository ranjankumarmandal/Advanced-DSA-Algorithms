public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] pos = new int[26][2];

        for (int i = 0; i < 26; i++) {
            pos[i][0] = -1;
            pos[i][1] = -1;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';

            result += (i - pos[c][1]) * (pos[c][1] - pos[c][0]);

            pos[c][0] = pos[c][1];
            pos[c][1] = i;
        }

        for (int c = 0; c < 26; c++) {
            result += (n - pos[c][1]) * (pos[c][1] - pos[c][0]);
        }

        return result;
    }
}