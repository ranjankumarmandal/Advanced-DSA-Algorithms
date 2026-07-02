public class SatisfiabilityOfEqualEquations {
    int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) parent[i] = i;

        for (String e : equations) {
            if (e.charAt(1) == '=') {
                union(e.charAt(0) - 'a', e.charAt(3) - 'a');
            }
        }

        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}