public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;

            int[] queue = new int[n];
            int front = 0, rear = 0;
            queue[rear++] = i;
            color[i] = 1;

            while (front < rear) {
                int node = queue[front++];
                for (int nei : graph[node]) {
                    if (color[nei] == 0) {
                        color[nei] = -color[node];
                        queue[rear++] = nei;
                    } else if (color[nei] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}