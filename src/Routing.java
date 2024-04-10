import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Routing {
    public static ArrayList<Wire> findPaths(Board board, ArrayList<Endpoints> goals) {
        ArrayList<Wire> wires = new ArrayList<>();
        for (Endpoints endpts : goals) {
            Wire wire = pathFind(board, endpts);
            if (wire != null) {
                wires.add(wire);
            }
        }
        return wires;
    }

    private static boolean bfs(Board board, Coord start, Coord target, HashMap<Coord, Coord> pathMap) {
        Queue<Coord> queue = new LinkedList<>();
        HashSet<Coord> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Coord current = queue.poll();
            if (current.equals(target)) {
                return true;
            }
            for (Coord neighbor : board.adj(current)) {
                if (!visited.contains(neighbor) && !board.isObstacle(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    pathMap.put(neighbor, current);
                }
            }
        }
        return false;
    }

    private static Wire pathFind(Board board, Endpoints endpts) {
        HashMap<Coord, Coord> pathMap = new HashMap<>();
        if (!bfs(board, endpts.start, endpts.end, pathMap)) {
            return null;
        }
        Wire wire = new Wire(endpts.id);
        Coord current = endpts.end;
        while (!current.equals(endpts.start)) {
            wire.add(current);
            current = pathMap.get(current);
        }
        wire.add(endpts.start);
        Collections.reverse(wire.getPoints());
        return wire;
    }
}
