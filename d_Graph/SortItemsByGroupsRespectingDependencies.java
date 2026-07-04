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

        List<Integer> groupOrder = topoSort(groupGraph, groupIndeg);
        if (groupOrder.size() != groupId) return new int[0];

        List<List<Integer>> itemsInGroup = new ArrayList<>();
        for (int i = 0; i < groupId; i++) itemsInGroup.add(new ArrayList<>());
        for (int i = 0; i < n; i++) itemsInGroup.get(group[i]).add(i);

        List<Integer> itemOrder = topoSort(itemGraph, itemIndeg);
        if (itemOrder.size() != n) return new int[0];

        Map<Integer, List<Integer>> orderedGroupItems = new HashMap<>();
        for (int i = 0; i < groupId; i++) orderedGroupItems.put(i, new ArrayList<>());
        for (int item : itemOrder) {
            orderedGroupItems.get(group[item]).add(item);
        }

        List<Integer> result = new ArrayList<>();
        for (int g : groupOrder) {
            result.addAll(orderedGroupItems.get(g));
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = result.get(i);
        return ans;
    }

    List<Integer> topoSort(List<List<Integer>> graph, int[] indeg) {
        int n = graph.size();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);
            for (int v : graph.get(u)) {
                if (--indeg[v] == 0) q.add(v);
            }
        }

        return res;
    }
}