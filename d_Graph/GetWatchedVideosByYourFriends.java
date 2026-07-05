public class GetWatchedVideosByYourFriends {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        vis[id] = true;

        while (level-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.poll();
                for (int v : friends[u]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        Map<String, Integer> freq = new HashMap<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            for (String video : watchedVideos.get(u)) {
                freq.put(video, freq.getOrDefault(video, 0) + 1);
            }
        }

        List<String> ans = new ArrayList<>(freq.keySet());
        ans.sort((a, b) -> {
            if (!freq.get(a).equals(freq.get(b))) {
                return freq.get(a) - freq.get(b);
            }
            return a.compareTo(b);
        });
    }
}