public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }



        return swaps;
    }
}