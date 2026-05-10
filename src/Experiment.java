public class Experiment {
    //Arrays to store execution times for 3 sizes: 10, 30, 100
    private long[] bfsTimes = new long[3];
    private long[] dfsTimes = new long[3];

    public void runTraversals(Graph g, int index) {
        //Measure BFS time starting from vertex 0
        long startBFS = System.nanoTime();
        g.bfs(0);
        long endBFS = System.nanoTime();
        bfsTimes[index] = endBFS - startBFS;

        //Measure DFS time
        long startDFS = System.nanoTime();
        g.dfs(0);
        long endDFS = System.nanoTime();
        dfsTimes[index] = endDFS - startDFS;

        System.out.println();
    }

    public void runMultipleTests() {
        System.out.println("SMALL GRAPH 10 Vertices");
        Graph smallGraph = buildGraph(10);
        //Print graph structure only for the small graph as required
        smallGraph.printGraph();
        runTraversals(smallGraph, 0);

        System.out.println("MEDIUM GRAPH 30 Vertices");
        Graph mediumGraph = buildGraph(30);
        runTraversals(mediumGraph, 1);

        System.out.println("LARGE GRAPH 100 Vertices");
        Graph largeGraph = buildGraph(100);
        runTraversals(largeGraph, 2);
    }

    public void printResults() {
        System.out.println("EXPERIMENTAL RESULTS");
        System.out.println("Size\t| BFS Time\t| DFS Time");
        System.out.println("-----------------------------------------");
        System.out.println("10\t| " + bfsTimes[0] + "\t\t| " + dfsTimes[0]);
        System.out.println("30\t| " + bfsTimes[1] + "\t\t| " + dfsTimes[1]);
        System.out.println("100\t| " + bfsTimes[2] + "\t\t| " + dfsTimes[2]);
    }

    private Graph buildGraph(int size) {
        Graph g = new Graph();
        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        //Connect adjacent nodes and add branches for a more complex structure
        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
            if (i + 2 < size) {
                g.addEdge(i, i + 2);
            }
        }
        return g;
    }
}