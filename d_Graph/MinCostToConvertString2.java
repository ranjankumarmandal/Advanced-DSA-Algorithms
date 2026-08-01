public class MinCostToConvertString2 {
    static class Node {
        Node[] next = new Node[26];
        int id = -1;
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int m = original.length;
        Node root = new Node();
        int id = 0;

        for (String s : original) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int x = c - 'a';
                if (cur.next[x] == null) cur.next[x] = new Node();
                cur = cur.next[x];
            }
            if (cur.id == -1) cur.id = id++;
        }

    }
}