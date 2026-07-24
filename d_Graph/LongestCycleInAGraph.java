public class LongestCycleInAGraph {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] state = new int[n];
        int[] time = new int[n];
        int ans = -1;
        int t = 1;

        for (int i = 0; i < n; i++) {
            if (state[i] != 0) continue;

            int curr = i;
            while (curr != -1 && state[curr] == 0) {
                state[curr] = 1;
                time[curr] = t++;
                curr = edges[curr];
            }
        }
    }
}