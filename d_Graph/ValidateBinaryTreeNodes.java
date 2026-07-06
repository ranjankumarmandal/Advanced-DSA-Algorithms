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

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                if (root != -1) return false;
                root = i;
            }
        }

        if (root == -1) return false;

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        vis[root] = true;
        int count = 1;

    }
}