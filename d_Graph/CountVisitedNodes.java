import java.util.*;

public class CountVisitedNodes {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indeg = new int[n];

        for (int v : edges) indeg[v]++;

    }
}