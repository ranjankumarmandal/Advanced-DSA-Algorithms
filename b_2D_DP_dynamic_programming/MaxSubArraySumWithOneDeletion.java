public class MaxSubArraySumWithOneDeletion {
    ublic int maximumSum(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int sum = arr[0];
        left[0] = arr[0];
        int ans = arr[0];

        for (int i = 1; i < n; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            left[i] = sum;
            ans = Math.max(ans, sum);
        }

        sum = arr[n - 1];
        right[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sum = Math.max(arr[i], sum + arr[i]);
            right[i] = sum;
        }

        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, left[i - 1] + right[i + 1]);
        }

        return ans;
    }
}