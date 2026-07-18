public class ParallelCourses3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[n];

        for (int[] r : relations) {
            graph[r[0] - 1].add(r[1] - 1);
            indegree[r[1] - 1]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = time[i];
            if (indegree[i] == 0) q.offer(i);
        }

    }
}