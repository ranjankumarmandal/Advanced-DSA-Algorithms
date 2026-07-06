import java.util.*;

public class ValidateBinaryTreeNodes {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indeg = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                indeg[leftChild[i]]++;
                if (indeg[leftChild[i]] > 1) return false;
            }
            if (rightChild[i] != -1) {
                indeg[rightChild[i]]++;
                if (indeg[rightChild[i]] > 1) return false;
            }
        }
    }
}