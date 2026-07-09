public class MaximumNumEdgesToRemove {
    int[] parent;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}