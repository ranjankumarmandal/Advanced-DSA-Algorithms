public class StampingTheSequence {
    public int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int m = s.length, n = t.length;
        boolean[] visited = new boolean[n];
        int stars = 0;
        List<Integer> res = new ArrayList<>();

        while (stars < n) {
            boolean changed = false;

            for (int i = 0; i <= n - m; i++) {
                if (!visited[i] && canStamp(t, i, s)) {
                    stars += doStamp(t, i, m);
                    visited[i] = true;
                    changed = true;
                    res.add(i);

                    if (stars == n) {
                        break;
                    }
                }
            }

            if (!changed) {
                return new int[0];
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(res.size() - 1 - i);
        }
        return ans;
    }

    private boolean canStamp(char[] target, int pos, char[] stamp) {
        boolean hasMatch = false;

        for (int i = 0; i < stamp.length; i++) {
        }

        return hasMatch;
    }
}