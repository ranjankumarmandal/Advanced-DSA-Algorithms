import java.util.*;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : barcodes) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
    }
}