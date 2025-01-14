package hw_6.bai1;

import java.util.Iterator;

public class TestFirstGraph {
    public static void main(String[] args) {
        // Tạo đồ thị với số đỉnh tối đa là 5
        FirstGraph graph = new FirstGraph(5);

        // **Test insertVertex**
        System.out.println("Test insertVertex:");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        System.out.println("Số lượng đỉnh hiện tại: " + graph.numVertices()); // Kỳ vọng: 3

        // **Test insertEdge**
        System.out.println("\nTest insertEdge:");
        graph.insertEdge(0, 1); // A-B
        graph.insertEdge(1, 2); // B-C
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

        // **Test edges**
        System.out.println("\nTest edges:");
        Iterator edges = graph.edges();
        while (edges.hasNext()) {
            System.out.print(edges.next() + " "); // Kỳ vọng: AB BC
        }
        System.out.println();

        // **Test getEdge**
        System.out.println("\nTest getEdge:");
        graph.getEdge("A", "B"); // Kỳ vọng: 0:1
        graph.getEdge("A", "C"); // Kỳ vọng: NULL

        // **Test removeEdge**
        System.out.println("\nTest removeEdge:");
        graph.removeEdge(0, 1); // Xóa cạnh A-B
        System.out.println("Ma trận kề sau khi xóa cạnh A-B:");
        graph.printMatrix();
        System.out.println("Số lượng cạnh sau khi xóa: " + graph.numEdges()); // Kỳ vọng: 1

        // **Test removeVertex**
        System.out.println("\nTest removeVertex:");
        graph.removeVertex("B"); // Xóa đỉnh B
        System.out.println("Ma trận kề sau khi xóa đỉnh B:");
        graph.printMatrix();
        System.out.println("Số lượng đỉnh hiện tại: " + graph.numVertices()); // Kỳ vọng: 2
    }
}
