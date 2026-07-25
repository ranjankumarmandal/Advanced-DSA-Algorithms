public class MostProfitablePathInATree {
    List<Integer>[] graph;
    int[] parent;
    int[] depth;
    int[] bobTime;
    int[] amount;
    int ans = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        this.amount = amount;

    }
}