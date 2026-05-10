import java.util.*;

public class Graph {
    private Map<Integer, LinkedList<Integer>> adjacencyList;
    private Map<Integer, Vertex> vertices;

    public Graph() {
        adjacencyList = new HashMap<>();
        vertices = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new LinkedList<>());
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
    }

    public void printGraph() {
        for (int vertexId : adjacencyList.keySet()) {
            System.out.print("Vertex " + vertexId + " connected to: ");
            for (int neighbor : adjacencyList.get(vertexId)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        // Logic: Use a Queue to visit nodes level by level (breadth-first).
        // A HashSet keeps track of visited nodes to prevent infinite loops.
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.getOrDefault(current, new LinkedList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        // Logic: Use recursion to go as deep as possible along each branch before backtracking.
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.getOrDefault(current, new LinkedList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}