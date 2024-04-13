import java.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Routing {

    /**
     * TODO
     * <p>
     * The findPaths function takes a board and a list of goals that contain
     * endpoints that need to be connected. The function returns a list of
     * Paths that connect the points.
     */

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
//        visited.add(start);
        while (!queue.isEmpty()) {
            Coord current = queue.remove();
            visited.add(current);
            if (current.equals(target)) {
                return true;
            }
//            board.getValue(neighbor) == 0;
            for (Coord neighbor : board.adj(current)) {
                if ((!visited.contains(neighbor) || neighbor.equals(target)) && (!board.isOccupied(neighbor))) {
                    queue.add(neighbor);
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

        Coord current = endpts.end;

        ArrayList<Coord> points = new ArrayList<>();

        while (!current.equals(endpts.start)) {
            points.add(current); // Add current point to points list

           // wire.add(points.get(current, pathMap.get(current)));
            current = pathMap.get(current);    // Move to the next point in the path
        }

        points.add(endpts.start); // Add the starting point

        Collections.reverse(points); // Reverse the list to get the correct order


        Wire wire = new Wire(endpts.id, points);

//        Collections.reverse(wire.getPoints());
        board.placeWire(wire);
        return wire;
    }






}

