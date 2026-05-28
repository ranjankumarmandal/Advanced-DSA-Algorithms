public class MaxDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> arr = arrays.get(i);
            int first = arr.get(0);

        return ans;
    }
}