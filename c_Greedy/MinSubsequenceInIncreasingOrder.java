import java.util.*;

public class MinSubsequenceInIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for (int num : nums) total += num;

    }
}