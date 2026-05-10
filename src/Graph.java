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

