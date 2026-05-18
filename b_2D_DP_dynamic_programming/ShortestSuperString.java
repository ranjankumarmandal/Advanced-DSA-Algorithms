public class ShortestSuperString {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] overlap = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                int max = Math.min(words[i].length(), words[j].length());

                for (int k = max; k >= 0; k--) {
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlap[i][j] = k;
                        break;
                    }
                }
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] parent = new int[1 << n][n];

        for (int mask = 0; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                parent[mask][i] = -1;
            }
        }

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int last = 0; last < n; last++) {
                if ((mask & (1 << last)) == 0) continue;

                int prevMask = mask ^ (1 << last);

                if (prevMask == 0) continue;

                for (int prev = 0; prev < n; prev++) {
                    if ((prevMask & (1 << prev)) == 0) continue;

                    int val = dp[prevMask][prev] + overlap[prev][last];

                    if (val > dp[mask][last]) {
                        dp[mask][last] = val;
                        parent[mask][last] = prev;
                    }
                }
            }
        }

        int mask = (1 << n) - 1;
        int last = 0;

        for (int i = 1; i < n; i++) {
            if (dp[mask][i] > dp[mask][last]) {
                last = i;
            }
        }

        int[] path = new int[n];
        boolean[] used = new boolean[n];
        int idx = n - 1;

        while (last != -1) {
            path[idx--] = last;
            used[last] = true;

            int temp = parent[mask][last];
            mask ^= (1 << last);
            last = temp;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                path[idx--] = i;
            }
        }

        StringBuilder sb = new StringBuilder(words[path[0]]);

        for (int i = 1; i < n; i++) {
            int a = path[i - 1];
            int b = path[i];

            sb.append(words[b].substring(overlap[a][b]));
        }

        return sb.toString();
    }
}