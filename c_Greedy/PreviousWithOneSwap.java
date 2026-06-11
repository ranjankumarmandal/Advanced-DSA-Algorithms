public class PreviousWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;

        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        if (i < 0) return arr;

        int j = n - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
    }
}