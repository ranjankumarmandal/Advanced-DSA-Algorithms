public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        int m = 0;
        for (int x : arr2) {
            if (m == 0 || arr2[m - 1] != x) {
                arr2[m++] = x;
            }
        }

        int INF = 1 << 30;

        int[] arr = new int[arr1.length + 2];
        arr[0] = -INF;
        arr[arr.length - 1] = INF;

        for (int i = 0; i < arr1.length; i++) {
            arr[i + 1] = arr1[i];
        }

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1];
            }

            int j = lowerBound(arr2, m, arr[i]);

            for (int k = 1; k <= Math.min(i - 1, j); k++) {
                if (arr[i - k - 1] < arr2[j - k]) {
                    dp[i] = Math.min(dp[i], dp[i - k - 1] + k);
                }
            }
        }

        return dp[n - 1] >= INF ? -1 : dp[n - 1];
    }

    p
}