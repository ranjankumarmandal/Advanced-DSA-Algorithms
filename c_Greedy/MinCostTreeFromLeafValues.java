import java.util.*;

public class MinCostTreeFromLeafValues {
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(Integer.MAX_VALUE);

        for (int x : arr) {
            while (st.peek() <= x) {
                int mid = st.pop();
                res += mid * Math.min(st.peek(), x);
            }
        }
    }
}