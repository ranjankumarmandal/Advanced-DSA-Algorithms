import java.util.*;

public class CollectCoinsInATree {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        if (n == 1) return 0;

        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int[] deg = new int[n];

    }
}