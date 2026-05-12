public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        boolean possible = false;

        for (int k = 1; k <= n / 2; k++) {
            if ((totalSum * k) % n == 0) {
                possible = true;
                break;
            }
        }

        if (!possible) return false;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= n / 2; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(0).add(0);

        for (int num : nums) {
            for (int k = n / 2; k >= 1; k--) {
                Set<Integer> prev = new HashSet<>(dp.get(k - 1));

                for (int sum : prev) {
                    dp.get(k).add(sum + num);
                }
            }
        }

        for (int k = 1; k <= n / 2; k++) {
            if ((totalSum * k) % n == 0) {
                int target = (totalSum * k) / n;

                if (dp.get(k).contains(target)) {
                    return true;
                }
            }
        }

        return false;
    }
}