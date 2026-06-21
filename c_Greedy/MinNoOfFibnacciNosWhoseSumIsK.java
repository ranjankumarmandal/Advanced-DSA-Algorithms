public class MinNoOfFibnacciNosWhoseSumIsK {
    public int findMinFibonacciNumbers(int k) {
        java.util.List<Integer> fib = new java.util.ArrayList<>();
        fib.add(1);
        fib.add(1);

        while (fib.get(fib.size() - 1) < k) {
            int n = fib.size();
            fib.add(fib.get(n - 1) + fib.get(n - 2));
        }

        int count = 0;
        int i = fib.size() - 1;

        while (k > 0) {
            if (fib.get(i) <= k) {
                k -= fib.get(i);
                count++;
            } else {
                i--;
            }
        }
    }
}