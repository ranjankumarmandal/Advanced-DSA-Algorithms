public class MinimizeTheTotalPriceOfTheTrips {
    List<Integer>[] g;
    int[] cnt;
    int[] price;
    long[][] dp;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        cnt = new int[n];
        for (int[] t : trips) {
            dfsCount(t[0], -1, t[1]);
        }
        dp = new long[n][2];
        dfsDP(0, -1);
        return (int) Math.min(dp[0][0], dp[0][1]);
    }

    }
}