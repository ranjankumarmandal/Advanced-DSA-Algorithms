import java.util.*;

public class MaxNumOfCoins {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int ans = 0;
        int l = 0, r = n - 2;

        while (l < r) {
            ans += piles[r];
            r -= 2;
            l++;
        }

        return ans;
    }
}