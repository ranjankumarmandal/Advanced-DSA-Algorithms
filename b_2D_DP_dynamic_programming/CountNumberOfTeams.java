public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int j = 0; j < n; j++) {
            int leftLess = 0, leftGreater = 0;
            int rightLess = 0, rightGreater = 0;



            ans += leftLess * rightGreater + leftGreater * rightLess;
        }

        return ans;
    }
}