import java.util.*;

public class ReachableNodesWithRestrictions {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> blocked = new HashSet<>();
        for (int x : restricted) {
            blocked.add(x);
        }

    }
}