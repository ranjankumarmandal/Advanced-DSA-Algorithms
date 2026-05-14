public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        Arrays.sort(arr);

        Map<Integer, Long> dp = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        long result = 0;

        for (int i = 0; i < arr.length; i++) {
            long ways = 1;



            dp.put(arr[i], ways);
            result = (result + ways) % mod;
        }

        return (int) result;
    }
}