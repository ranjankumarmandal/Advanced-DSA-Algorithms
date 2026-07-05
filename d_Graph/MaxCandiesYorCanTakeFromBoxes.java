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

        while (!q.isEmpty()) {
            int box = q.poll();
            ans += candies[box];

            for (int key : keys[box]) {
                if (status[key] == 0) {
                    status[key] = 1;
                    if (haveBox[key] && !opened[key]) {
                        opened[key] = true;
                        q.offer(key);
                    }
                }
            }
    }
}