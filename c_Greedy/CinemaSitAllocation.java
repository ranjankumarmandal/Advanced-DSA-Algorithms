import java.util.*;

public class CinemaSitAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << col));
            }
        }

        int ans = (n - map.size()) * 2;

        int left = 0, middle = 0, right = 0;
        for (int c = 2; c <= 5; c++) left |= 1 << c;
        for (int c = 4; c <= 7; c++) middle |= 1 << c;
        for (int c = 6; c <= 9; c++) right |= 1 << c;
    }
}