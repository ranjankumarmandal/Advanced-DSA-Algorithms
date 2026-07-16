import java.util.*;

public class CountWaysToBuildRoomsInAnAntColony {
    static final long MOD = 1000000007L;

    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) g[prevRoom[i]].add(i);

    }
}