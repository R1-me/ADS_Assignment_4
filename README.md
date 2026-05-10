# ADS_Assignment_4

## A. Project Overview
This project implements a graph data structure using an adjacency list and explores two fundamental graph traversal algorithms: Breadth-First Search and Depth-First Search. The goal is to represent vertices and edges effectively and analyze how these algorithms perform on graphs of different sizes

## B. Class Descriptions
* Vertex: A class representing a node in the graph, containing a unique integer ID.
* Edge: A class representing a connection from a source vertex to a destination vertex.
* Graph: The main structure that manages the adjacency list. It handles adding vertices, creating edges, and executing traversal algorithms.
* Experiment: A helper class designed to automate tests, generate graphs with 10, 30, and 100 vertices, and measure execution time in nanoseconds.

## C. Algorithm Descriptions
### Breadth-First Search (BFS)
BFS explores the graph layer by layer. Starting from a source node, it visits all immediate neighbors before moving to the next level. This algorithm uses a Queue (FIFO) to manage the discovery order and a Set to keep track of visited nodes to avoid cycles. It is ideal for finding the shortest path in unweighted graphs.
* Time Complexity: O(V + E)

### Depth-First Search (DFS)
DFS explores as far as possible along each branch before backtracking. It follows one path to its end, then returns to the last decision point to try another path. This implementation uses recursion to dive into the graph depth. DFS is commonly used for pathfinding, topological sorting, and cycle detection.
* Time Complexity: O(V + E)

## D. Experimental Results

| Graph Size | BFS Execution Time (ns) | DFS Execution Time (ns) |
|------------|-------------------------|-------------------------|
| 10         | 618900                  | 399800                  |
| 30         | 263600                  | 82000                   |
| 100        | 389700                  | 277100                  |

### Analysis
* **Performance Impact**: The initial test with 10 vertices took the longest time due to the Java Virtual Machine (JVM) warmup and class loading overhead. However, when observing the medium and large graphs, the execution time correctly increases from 30 to 100 vertices because there are more nodes and connections to process
* **Comparison: In my experiments, DFS was consistently faster than BFS across all test cases. This indicates that for this structure, the recursive calls in DFS had less overhead than managing the Queue object in BFS
* complexity Validation: Excluding the initial JVM warmup phase, the execution time scales proportionally as the graph size increases from 30 to 100 vertices. This confirms the expected O(V + E) linear complexity for both algorithms
* Use Cases: BFS remains the preferred choice for finding the shortest paths in unweighted structures, while DFS is more efficient for exploring deep branches or checking connectivity when the target node is far from the root

## E. Screenshots
All results, including the graph structure, traversal orders for the small graph, and performance metrics, are captured in the execution output below:

<img width="1920" height="1080" alt="Снимок экрана 2026-05-10 220726" src="https://github.com/user-attachments/assets/3467903d-676f-4d04-9298-e221d394982d" />



## F. Reflection
Through this assignment, I gained a practical understanding of how to move from theoretical graph concepts to a working Java implementation. Implementing the adjacency list using a HashMap and LinkedList was a great way to see how we can efficiently store and manage connections between nodes. The most interesting part was comparing BFS and DFS; it was fascinating to see how BFS uses a Queue to explore neighbors layer by layer, while DFS uses recursion to go as deep as possible before backtracking

One of the main challenges I faced was managing the console output. For a small graph, seeing the traversal order is helpful, but for 100 vertices, the output becomes unreadable. I solved this by adding logic to only print the path for graphs with 10 vertices or fewer. Additionally, using `System.nanoTime()` taught me how to measure performance accurately, and analyzing the data helped me understand real-world Java concepts like JVM warmup. Overall, this project helped me bridge the gap between abstract algorithm logic and clean, object-oriented code
