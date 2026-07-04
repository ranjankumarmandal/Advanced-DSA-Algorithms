import java.util.*;

public class SortItemsByGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = groupId++;
        }

    }
}