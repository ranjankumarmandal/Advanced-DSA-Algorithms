public class MinimizeTheTotalPriceOfTheTrips {
    List<Integer>[] g;
    int[] cnt;
    int[] price;
    long[][] dp;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
    }
}