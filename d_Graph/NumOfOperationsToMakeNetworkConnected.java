import java.util.*;

public class NumOfOperationsToMakeNetworkConnected {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}