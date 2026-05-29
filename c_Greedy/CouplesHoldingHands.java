public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        int swaps = 0;

        for (int i = 0; i < n; i += 2) {
            int first = row[i];
            int partner = first ^ 1;

            if (row[i + 1] != partner) {
                swaps++;

                int partnerPos = pos[partner];
                int second = row[i + 1];

                row[partnerPos] = second;
                pos[second] = partnerPos;

                row[i + 1] = partner;
                pos[partner] = i + 1;
            }
        }

        return swaps;
    }
}