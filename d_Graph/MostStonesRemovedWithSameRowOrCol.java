public class MostStonesRemovedWithSameRowOrCol {
    int[] parent;

    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;

    }
}