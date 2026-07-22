public class MaxImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }

        Arrays.sort(degree);

    }
}