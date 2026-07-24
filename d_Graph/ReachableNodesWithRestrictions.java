import java.util.*;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> blocked = new HashSet<>();
        for (int x : restricted) {
            blocked.add(x);
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int next : graph[node]) {
                if (!visited[next] && !blocked.contains(next)) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return count;
    }
}