public class MaxSubArraySumWithOneDeletion {
    ublic int maximumSum(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int sum = arr[0];
        left[0] = arr[0];
        int ans = arr[0];



        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, left[i - 1] + right[i + 1]);
        }

        return ans;
    }
}