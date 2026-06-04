import java.util.*;

public class MinAddToMakeParenthesisValid {
    public int minAddToMakeValid(String s) {
        int balance = 0;
        int additions = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            }
        }

        return additions + balance;
    }
}