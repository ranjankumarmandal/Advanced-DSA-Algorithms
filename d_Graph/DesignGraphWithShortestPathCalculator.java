import java.util.*;

public class DesignGraphWithShortestPathCalculator {
    private int n;
    private List<int[]>[] graph;
    private static final int INF = 1000000000;

    public Graph(int n, int[][] edges) {
        this.n = n;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(new int[]{e[1], e[2]});
    }
}