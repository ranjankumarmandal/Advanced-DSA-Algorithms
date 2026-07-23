public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        Arrays.fill(d1, -1);
        Arrays.fill(d2, -1);

        int cur = node1;
        int dist = 0;
        while (cur != -1 && d1[cur] == -1) {
            d1[cur] = dist++;
            cur = edges[cur];
        }

        cur = node2;
        dist = 0;
        while (cur != -1 && d2[cur] == -1) {
            d2[cur] = dist++;
            cur = edges[cur];
        }

    }
}