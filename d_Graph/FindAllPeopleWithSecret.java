public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        union(parent, 0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> curr = new ArrayList<>();
            Set<Integer> persons = new HashSet<>();
        }
}