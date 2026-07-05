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
    }
}