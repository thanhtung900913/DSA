package hw_6.bai1;

import java.util.Iterator;

public interface Graph {

    // Returns the number of vertices in the graph.
    int numVertices();

    // Returns an iteration of all the vertices in the graph.
    Iterator vertices();

    // Returns the number of edges in the graph.
    int numEdges();

    // Returns an iteration of all the edges in the graph.
    Iterator edges();

    // Returns the edge from vertex u to vertex v, or null if no such edge exists.
    void getEdge(String u, String v);

    // Returns an array containing the two endpoint vertices of edge e.
    // If the graph is directed, the first vertex is the origin, and the second is the destination.
    int[] endVertices(int e);

    // For edge e incident to vertex v, returns the other vertex of the edge.
    // Throws an exception if e is not incident to v.
    int opposite(int v, int e);

    // Returns the number of outgoing edges from vertex v.
    int outDegree(String v);

    // Returns the number of incoming edges to vertex v.
    int inDegree(int v);

    // Returns an iteration of all outgoing edges from vertex v.
    Iterator outgoingEdges(int v);

    // Returns an iteration of all incoming edges to vertex v.
    Iterator incomingEdges(int v);

    // Creates and returns a new Vertex storing element x.
    void insertVertex(String x);

    // Creates and returns a new Edge from vertex u to vertex v, storing element x.
    // Throws an exception if there already exists an edge from u to v.
    void insertEdge(int u, int v);

    // Removes vertex v and all its incident edges from the graph.
    void removeVertex(String v);

    // Removes edge e from the graph.
    void removeEdge(int u, int v);
}

