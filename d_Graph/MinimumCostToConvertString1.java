import java.util.*;

public class MinimumCost {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        long inf = (long) 1e18;

        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }

    }
}