public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }

        int[] personMask = new int[people.size()];

        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (String skill : people.get(i)) {
                if (skillMap.containsKey(skill)) {
                    mask |= (1 << skillMap.get(skill));
                }
            }
            personMask[i] = mask;
        }

        List<Integer>[] dp = new ArrayList[1 << n];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            int skill = personMask[i];

            for (int mask = 0; mask < (1 << n); mask++) {
                if (dp[mask] == null) continue;

                int newMask = mask | skill;


            }
        }

        List<Integer> ans = dp[(1 << n) - 1];
        int[] res = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}