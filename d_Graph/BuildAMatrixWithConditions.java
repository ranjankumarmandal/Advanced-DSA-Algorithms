public class BuildAMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topoSort(k, rowConditions);
        if (rowOrder == null) return new int[0][0];

        int[] colOrder = topoSort(k, colConditions);
        if (colOrder == null) return new int[0][0];

    }
}