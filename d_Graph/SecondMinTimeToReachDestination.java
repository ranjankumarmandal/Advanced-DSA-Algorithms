import java.util.*;

public class SecondMinTimeToReachDestination {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] first = new int[n + 1];
        int[] second = new int[n + 1];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(second, Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1, 0});
        first[1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], t = cur[1];

            int depart = t;
            if ((depart / change) % 2 == 1) {
                depart = (depart / change + 1) * change;
            }
            int arrive = depart + time;

            for (int v : graph[u]) {
                if (arrive < first[v]) {
                    second[v] = first[v];
                    first[v] = arrive;
                    q.offer(new int[]{v, arrive});
                } else if (arrive > first[v] && arrive < second[v]) {
                    second[v] = arrive;
                    q.offer(new int[]{v, arrive});
                }
            }
        }
    }
}