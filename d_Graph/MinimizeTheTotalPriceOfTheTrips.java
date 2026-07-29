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

    boolean dfsCount(int u, int p, int target) {
        if (u == target) {
            cnt[u]++;
            return true;
        }
        for (int v : g[u]) {
            if (v == p) continue;
            if (dfsCount(v, u, target)) {
                cnt[u]++;
                return true;
            }
        }
        return false;
    }

    void dfsDP(int u, int p) {
        long notHalf = (long) cnt[u] * price[u];
        long half = (long) cnt[u] * (price[u] / 2);
        for (int v : g[u]) {
            if (v == p) continue;
            dfsDP(v, u);
            notHalf += Math.min(dp[v][0], dp[v][1]);
            half += dp[v][0];
        }
        dp[u][0] = notHalf;
        dp[u][1] = half;
    }
}