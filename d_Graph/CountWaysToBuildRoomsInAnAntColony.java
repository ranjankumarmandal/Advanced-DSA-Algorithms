import java.util.*;

public class CountWaysToBuildRoomsInAnAntColony {
    static final long MOD = 1000000007L;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) g[prevRoom[i]].add(i);

        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i > 0; i--) invFact[i - 1] = invFact[i] * i % MOD;

        int[] size = new int[n];
        long[] ways = new long[n];
        dfs(0, g, size, ways, fact, invFact);

        return (int) ways[0];
    }

    private void dfs(int u, List<Integer>[] g, int[] size, long[] ways, long[] fact, long[] invFact) {
        size[u] = 1;
        long res = 1;
        int total = 0;
        for (int v : g[u]) {
            dfs(v, g, size, ways, fact, invFact);
            res = res * ways[v] % MOD;
            res = res * invFact[size[v]] % MOD;
            total += size[v];
            size[u] += size[v];
        }
        res = res * fact[total] % MOD;
        ways[u] = res;
    }
}