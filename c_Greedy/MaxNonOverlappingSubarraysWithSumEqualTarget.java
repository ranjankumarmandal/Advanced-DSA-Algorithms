public class MaxNonOverlappingSubarraysWithSumEqualTarget {
    ublic int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;

            if (set.contains(sum - target)) {
                ans++;
                set.clear();
                set.add(0);
                sum = 0;
            } else {
                set.add(sum);
            }
        }
    }
}