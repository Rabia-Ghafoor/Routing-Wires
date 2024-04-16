Devs: Rabia, Myles, Alyssa

# Routing Algorithm for Wire Layout Optimization

## Overview of the Algorithm
- The routing algorithm aims to optimize wire layouts on a given board while connecting endpoints efficiently. It utilizes a combination of breadth-first search (BFS) for pathfinding and backtracking for optimizing wire placements and minimizing overlaps.
- **BFS Pathfinding**: The algorithm uses BFS to find paths between endpoints on the board. It maintains a path map to track the connections between coordinates during traversal.
- **Wire Placement**: After finding a valid path using BFS, the algorithm places the wire on the board and updates the wire label accordingly.
- **Backtracking**: In cases where a valid path cannot be found due to overlaps or obstacles, the algorithm employs backtracking. It removes previously placed wires and retries alternative paths to optimize wire layouts.

## Example Applications
Consider a board with multiple endpoints and obstacles. Here's how the algorithm would handle different scenarios:
- **Scenario 1**: Successfully connecting all endpoints without overlaps. In this case, the algorithm efficiently finds paths between endpoints and optimally places wires to minimize intersections.
- **Scenario 2**: Overlapping paths or blocked routes. The algorithm utilizes backtracking to remove conflicting wires and explores alternative paths, ensuring a successful and optimized wire layout.

## Overview of the Algorithm
The routing algorithm aims to optimize wire layouts on a given board while efficiently connecting endpoints. It combines breadth-first search (BFS) for pathfinding and backtracking for optimizing wire placements and minimizing overlaps.

## Example Applications
Consider a board with multiple endpoints and obstacles. Here's how the algorithm would handle different scenarios:
- **Scenario 1:** Successfully connecting all endpoints without overlaps.
- **Scenario 2:** Overlapping paths or blocked routes, utilizing backtracking to resolve conflicts and find alternative paths.

## Evaluation of Algorithm Performance
### Evaluation of algorithm with respect to finding and minimizing wire layouts
-**Strengths:** If there is a solution, the algorithm will find it. Additionally, due to the use of backtracking, the algorithm can be more flexible and can find better alternative routes to minimize the wire layout. 
-**Weaknesses:** The algorithm may terminate early after finding one path and miss a different, more optimal path. Can have a long runtime/large space requirements with larger, more complex boards 
#### BFS (Breadth-First Search) Time Complexity:
- Queue Operations: O(1) per coordinate
- Visited Set Operations: O(1) per coordinate
- Adjacency Checking: O(k), where k is the number of neighbors per coordinate
- Overall time complexity: O(V + E), where V is the number of vertices (coordinates) and E is the number of edges (connections)

#### Backtracking Time Complexity:2
- Recursion Depth: Up to O(m^n), where m is the average possible paths per endpoint and n is the number of endpoints
- Operations per Recursion Level: O(V + E) for path finding and wire placement
- Overall time complexity: O(m^n * (V + E)), worst-case exploring all possible path combinations

#### Wall-clock Time Analysis 
-The algorithm is reasonably quick, notably completing the full suite of autograder tests in under a minute. Furthermore, it does not timeout on tests of its speed unlike earlier versions of the algorithm 

## Conclusion
The routing algorithm offers an effective solution for optimizing wire layouts by combining BFS pathfinding and backtracking techniques. Its ability to handle overlapping paths and obstacles makes it suitable for a wide range of board layouts, ensuring efficient wire connections with minimal overlaps.
