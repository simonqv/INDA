import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * A graph with a fixed number of vertices implemented using adjacency maps.
 * Space complexity is &Theta;(n + m) where n is the number of vertices and m
 * the number of edges.
 *
 * @author Simon Larspers Qvist
 * @version 24-02-21
 */
public class Graph {
    /**
     * The map edges[v] contains the key-value pair (w, c) if there is an edge from
     * v to w; c is the cost assigned to this edge. The maps may be null and are
     * allocated only when needed.
     */
    private final Map<Integer, Integer>[] edges;

    /** Number of edges in the graph. */
    private int numEdges;

    /** Number of vertices in the graph. (added by Simon) */
    private int numVertices;

    /**
     * Constructs a HashGraph with n vertices and no edges. Time complexity: O(n)
     *
     * @throws IllegalArgumentException if n < 0
     */
    public Graph(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n = " + n);

        // The array will contain only Map<Integer, Integer> instances created
        // in addEdge(). This is sufficient to ensure type safety.
        @SuppressWarnings("unchecked")
        Map<Integer, Integer>[] a = new HashMap[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = new HashMap<>();
            numVertices ++; /* added by Simon */
        }
        edges = a;
    }

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int numVertices() {
        return numVertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int numEdges() {
        return numEdges;
    }


    /**
     * Returns the outdegree of vertex v.
     *
     * @param v vertex
     * @return the outdegree of vertex v
     * @throws IllegalArgumentException if v is out of range
     */
    public int degree(int v) throws IllegalArgumentException {
        if (v >= edges.length) {
            throw new IllegalArgumentException();
        }
            return edges[v].size();
        }

    /**
     * Returns an iterator of vertices adjacent to v.
     *
     * @param v vertex
     * @return an iterator of vertices adjacent to v
     * @throws IllegalArgumentException if v is out of range
     */
    public Iterator<Integer> neighbors(int v) {
        return edges[v].keySet().iterator();
    }

    /**
     * Returns true if there is an edge (from, to).
     *
     * @param v vertex
     * @param w vertex
     * @return true if there is an edge (from, to).
     * @throws IllegalArgumentException if from or to are out of range
     */
    public boolean hasEdge(int v, int w) {
        if (v >= edges.length || v < 0 || w >= edges.length || w < 0) {
            throw new IllegalArgumentException();
        }
        return edges[v].containsKey(w) && edges[w].containsKey(v);
    }

    /**
     * Returns the edge cost if from and to are adjacent, otherwise -1.
     *
     * @param v vertex
     * @param w vertex
     * @return edge cost if available, -1 otherwise
     * @throws IllegalArgumentException if from or to are out of range
     */
    public int cost(int v, int w) throws IllegalArgumentException {
        if (v >= edges.length || v < 0 || w >= edges.length || w < 0) {
            throw new IllegalArgumentException();
        }
        return edges[v].getOrDefault(w, -2);

    }

    /**
     * Inserts an edge with edge cost c.
     *
     * @param c edge cost, c >= 0
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if from or to are out of range
     */
    public void add(int v, int w, int c) {
        if (v >= edges.length || v < 0 || w >= edges.length || w < 0) {
            throw new IllegalArgumentException();

        }
        if (!edges[v].containsKey(w) && !edges[w].containsKey(v)) {
            numEdges ++;
        }
        edges[v].put(w,c);
        edges[w].put(v,c);

    }

    /**
     * Removes the edges between v and w.
     *
     * @param v vertex
     * @param w vertex
     * @throws IllegalArgumentException if v or w are out of range
     */
    public void remove(int v, int w) {
        if (v >= edges.length || v < 0 || w >= edges.length || w < 0) {
            throw new IllegalArgumentException();
        }
        if (edges[v].containsKey(w) && edges[w].containsKey(v)) {
            edges[v].remove(w);
            edges[w].remove(v);
            numEdges --;
        }
    }

    /**
     * Returns a string representation of this graph.
     *
     * Should represent the graph in terms of edges (order does not matter). For
     * example, if a graph has edges (2,3,0) and (1,0,0), the
     * representaiton should be:
     *
     * "{(1,0,0), (2,3,0)}" or "{(2,3,0), (1,0,0)}"
     *
     * An empty graph is just braces:
     *
     * "{}"
     *
     * @return a String representation of this graph
     */
    @Override
    public String toString() {
        if (numEdges == 0) {
            return "{}";
        }

        boolean[][] added = new boolean[numVertices][numVertices];
        
        StringBuilder sb = new StringBuilder("{");

        for (int v = 0; v < numVertices ; v++) {
            if (!edges[v].isEmpty()) {
                int w = edges[v].keySet().iterator().next();
                int c = edges[v].get(w);
                //int c = edges[v].values().stream().mapToInt(Integer::intValue).toArray()[0];

                if (!added[v][w] && !added[w][v]) {
                    added[v][w] = true;
                    added[w][v] = true;
                    sb.append("(")
                            .append(v)
                            .append(",")
                            .append(w)
                            .append(",")
                            .append(c)
                            .append("), ");

                 }
            }

        }

        sb.setLength(sb.length() - 2);

        return sb.append("}").toString();
    }
}
