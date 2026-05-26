public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = 0;

        for (int dresses : machines) {
            total += dresses;
        }

        int n = machines.length;

        if (total % n != 0) {
            return -1;
        }

        return moves;
    }
}