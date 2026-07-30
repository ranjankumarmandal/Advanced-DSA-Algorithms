import java.util.*;

public class ModifyGraphEdgeWeights {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long inf = (long) 4e18;

        long d = dijkstra(n, edges, source, destination);
        if (d < target) return new int[0][];
        if (d == target) {
            for (int[] e : edges) {
                if (e[2] == -1) e[2] = 2000000000;
            }
            return edges;
        }

    }
}