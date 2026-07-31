public class FindChampion2 {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];

        for (int[] e : edges) {
            indegree[e[1]]++;
        }

        int ans = -1;

    }
}