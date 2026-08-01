public class MinCostToConvertString2 {
    static class Node {
        Node[] next = new Node[26];
        int id = -1;
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int m = original.length;
        Node root = new Node();
        int id = 0;
    }
}