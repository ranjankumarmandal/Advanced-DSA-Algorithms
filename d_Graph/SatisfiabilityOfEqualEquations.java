public class SatisfiabilityOfEqualEquations {
    int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) parent[i] = i;

    }
}