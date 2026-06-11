public class PreviousWithOneSwap {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;

        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
    }
}