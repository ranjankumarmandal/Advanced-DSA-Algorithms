public class MinDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, res = Integer.MAX_VALUE;
        int[] face = new int[7];

        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i]) face[bottoms[i]]++;
        }
    }
}