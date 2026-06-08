public class PancakeSorting {
    public List<Integer> pancakeSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] indices = new int[n];

        for(int i=0; i<n; ++i) indices[arr[i]-1] = i;
        for(int i=0; i<n; ++i) {
            int pull = indices[i];
            dew(stack, i, pull);
            indices[arr[i]-1] = pull;
            indices[i] = i;
            arr[pull] = arr[i];
            arr[i] = i+1;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while(!stack.isEmpty()) {
            int x = stack.pop();
            ans.addFirst(x);
        }
        return ans;
    }
}