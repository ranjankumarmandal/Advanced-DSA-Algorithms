import java.util.*;

public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : barcodes) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }
    }
}