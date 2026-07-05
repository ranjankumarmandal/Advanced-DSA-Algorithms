public class MaxCandiesYorCanTakeFromBoxes {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] haveBox = new boolean[n];
        boolean[] opened = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int box : initialBoxes) {
            haveBox[box] = true;
            if (status[box] == 1) {
                q.offer(box);
            }
        }

        int ans = 0;

    }
}