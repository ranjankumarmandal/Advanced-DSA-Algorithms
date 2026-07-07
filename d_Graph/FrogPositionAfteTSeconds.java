public class FrogPositionAfteTSeconds {
    List<Integer>[] graph;
    boolean[] vis;
    int target;
    int limit;
    double ans;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        this.target = target;
        this.limit = t;
        graph = new ArrayList[n + 1];
    }
}