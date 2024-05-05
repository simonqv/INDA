import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for solving graph problems.
 *
 * @author Simon Larspers Qvist
 * @version 24-02-21
 */
public class GraphAlgorithms {
    /**
    * Determines if a component has a cycle.
    *
    * @param g the graph to search
    * @param v the node to start at
    * @param visited boolean array keeping track of visited nodes
    * @param parent parent node of v
    * @return true if component has cycle, false otherwise
    */

    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        int next;
        //if (visited[v]) {return true;}

        //else {
            visited[v] = true;
            for (Iterator<Integer> it = g.neighbors(v); it.hasNext();) {
                //System.out.println(visited);
                next = it.next();
                //System.out.println("v= " + v + " Parent= " + parent + " next: " + next);
                if (next != parent && visited[next]) {
                    return true;
                } else if (next != parent) {
                    //System.out.println(next + " not parent to " + v + "\n");
                    DFS(g, next, visited, v);
                }
            }
        //}

        return false;
    }


    /**
    * Determine if there is a cycle in the graph. Implement using DFS.
    *
    * @param g the graph to search
    * @return true if there exists at least one cycle in the graph, false otherwise
    */
    public static boolean hasCycle(Graph g) {
        boolean[] visited = new boolean[g.numVertices()];
     //   boolean cycle = false;

        for (int v = 0; v < g.numVertices(); v++) {
            //cycle = DFS(g, v, visited, v);
            if (!visited[v]) {
                if (DFS(g, v, visited, v)) {return true;}
            }


        }
        return false;
    }

    /**

    * Determine if there is a path between two vertices. Implement using
    * BFS.
    *
    * @param v vertex
    * @param w vertex
    * @param g the graph to search
    * @return true if there is a path between v and w, false otherwise
    */
    public static boolean hasPath(Graph g, int v, int w) {
        boolean[] visited = new boolean[g.numVertices()];

        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (Iterator<Integer> it = g.neighbors(vertex); it.hasNext();) {
                int next = it.next();
                //System.out.println("vertex = " + vertex + " neighbor = " + next);
                //System.out.println(queue);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return visited[v] && visited[w];
    }
    }
