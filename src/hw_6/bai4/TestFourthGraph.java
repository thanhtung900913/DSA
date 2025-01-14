package hw_6.bai4;



import java.util.Iterator;

public class TestFourthGraph {
    public static void main(String[] args) {
        // Tạo đồ thị với số đỉnh tối đa là 5
        FourthGraph graph = new FourthGraph(5);

        // **Test insertVertex**
        System.out.println("Test insertVertex:");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        System.out.println("Số lượng đỉnh hiện tại: " + graph.numVertices()); // Kỳ vọng: 5

        // **Test insertEdge**
        System.out.println("\nTest insertEdge:");
        graph.insertEdge(0, 1, 5); // A-B với trọng số 5
        graph.insertEdge(1, 2, 10); // B-C với trọng số 10
        graph.insertEdge(0, 2, 4); //
        graph.insertEdge(0, 3, 5);
        graph.insertEdge(0, 4, 6);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(0, 2, 7);
        System.out.println("Ma trận kề:");
        graph.printMatrix();

        // **Test numEdges**
        System.out.println("\nTest numEdges:");
        System.out.println("Số lượng cạnh: " + graph.numEdges()); // Kỳ vọng: 2

        // **Test vertices**
        System.out.println("\nTest vertices:");
        Iterator vertices = graph.vertices();
        while (vertices.hasNext()) {
            System.out.print(vertices.next() + " "); // Kỳ vọng: A B C
        }
        System.out.println();

        // **Test dfs**
        System.out.println("DFS graph traversal");
        graph.dfs(0);

        // **Test bfs**
        System.out.println("BFS graph traversal");
        graph.bfs(0);
        // **Test edges**

        System.out.println("dijiktra:");
        graph.dijkstra(0, 2);

        System.out.println("hamilton:");
        graph.hamiltonianCycle();

        System.out.println("Euler:");
        graph.eulerianCycle();

        System.out.println("Cây bao trùm tối thiểu:");
        graph.primMST();

        System.out.println("Tô màu đồ thị: ");
        graph.graphColoring();
    }

}
