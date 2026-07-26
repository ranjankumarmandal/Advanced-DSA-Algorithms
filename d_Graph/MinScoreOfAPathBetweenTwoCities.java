public class MinScoreOfAPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] e : graph[u]) {
                ans = Math.min(ans, e[1]);
                if (!vis[e[0]]) {
                    vis[e[0]] = true;
                    q.offer(e[0]);
                }
            }
        }

        return ans;
    }
}