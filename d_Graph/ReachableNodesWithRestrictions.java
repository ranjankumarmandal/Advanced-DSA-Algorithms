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

    }
}