import java.util.*;

public class MaxPerformanceOfATeam {
    private static final int MOD = 1_000_000_007;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];

        for (int i = 0; i < n; i++) {
            eng[i][0] = efficiency[i];
            eng[i][1] = speed[i];
        }
    }
}