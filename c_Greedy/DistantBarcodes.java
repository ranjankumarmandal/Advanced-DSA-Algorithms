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

        int[] ans = new int[barcodes.length];
        int idx = 0;

        while (pq.size() >= 2) {
            int[] a = pq.poll();
            int[] b = pq.poll();

            ans[idx++] = a[0];
            ans[idx++] = b[0];

            if (--a[1] > 0) pq.offer(a);
            if (--b[1] > 0) pq.offer(b);
        }

        if (!pq.isEmpty()) {
            ans[idx] = pq.poll()[0];
        }
    }
}