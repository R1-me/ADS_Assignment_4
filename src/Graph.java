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
        //Use a Queue to visit nodes level by level (breadth-first)
        //A HashSet keeps track of visited nodes to prevent infinite loops
        boolean shouldPrint = vertices.size() <= 10;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        if (shouldPrint) System.out.print("BFS traversal: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (shouldPrint) System.out.print(current + " ");

            for (int neighbor : adjacencyList.getOrDefault(current, new LinkedList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        if (shouldPrint) System.out.println();
    }

    public void dfs(int start) {
        //Use recursion to go as deep as possible along each branch before backtrackin
        boolean shouldPrint = vertices.size() <= 10;
        Set<Integer> visited = new HashSet<>();

        if (shouldPrint) System.out.print("DFS traversal: ");
        dfsHelper(start, visited, shouldPrint);
        if (shouldPrint) System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited, boolean shouldPrint) {
        visited.add(current);
        if (shouldPrint) System.out.print(current + " ");

        for (int neighbor : adjacencyList.getOrDefault(current, new LinkedList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, shouldPrint);
            }
        }
    }
}