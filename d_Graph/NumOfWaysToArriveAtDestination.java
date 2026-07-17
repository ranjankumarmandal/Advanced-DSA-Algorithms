import java.util.*;

public class NumOfWaysToArriveAtDestination {
    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {
        List<long[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] r : roads) {
            graph[r[0]].add(new long[]{r[1], r[2]});
            graph[r[1]].add(new long[]{r[0], r[2]});
        }
    }
}