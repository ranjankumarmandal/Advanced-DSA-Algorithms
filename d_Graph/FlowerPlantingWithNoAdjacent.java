import java.util.*;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int nei : graph[i]) {
                used[ans[nei]] = true;
            }
            for (int color = 1; color <= 4; color++) {
                if (!used[color]) {
                    ans[i] = color;
                    break;
                }
            }
        }

        return ans;
    }
}
