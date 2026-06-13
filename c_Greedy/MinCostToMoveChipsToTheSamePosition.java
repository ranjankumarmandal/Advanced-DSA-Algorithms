public class MinCostToMoveChipsToTheSamePosition {
    ublic int minCostToMoveChips(int[] position) {
        int even = 0, odd = 0;

        for (int p : position) {
            if ((p & 1) == 0) even++;
        }
    }
}