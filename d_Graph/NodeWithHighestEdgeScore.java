public class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];

        for (int i = 0; i < edges.length; i++) {
            score[edges[i]] += i;
        }

        int ans = 0;

    }
}