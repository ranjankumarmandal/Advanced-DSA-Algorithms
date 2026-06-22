public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            }
        }
    }
}