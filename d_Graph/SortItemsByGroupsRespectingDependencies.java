import java.util.*;

public class SortItemsByGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = groupId++;
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) itemGraph.add(new ArrayList<>());
        for (int i = 0; i < groupId; i++) groupGraph.add(new ArrayList<>());

        int[] itemIndeg = new int[n];
        int[] groupIndeg = new int[groupId];

        for (int i = 0; i < n; i++) {
            for (int pre : beforeItems.get(i)) {
                itemGraph.get(pre).add(i);
                itemIndeg[i]++;
                if (group[pre] != group[i]) {
                    groupGraph.get(group[pre]).add(group[i]);
                    groupIndeg[group[i]]++;
                }
            }
        }

    }
}