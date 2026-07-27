import java.util.*;

public class MaxStarSumOfAGraph {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int nei : graph[i]) {
                if (vals[nei] > 0) {
                    pq.offer(vals[nei]);
                    if (pq.size() > k) {
                        pq.poll();
                    }
                }
            }

            int sum = vals[i];
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }
}