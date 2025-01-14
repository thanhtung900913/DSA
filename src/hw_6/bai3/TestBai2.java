package hw_6.bai3;

import hw_6.bai2.SecondGrahp;

import java.util.Iterator;

public class TestBai2 {
    public static void main(String[] args) {
        // Tạo đồ thị với số đỉnh tối đa là 5
        SecondGrahp graph = new SecondGrahp(5);

        // **Test insertVertex**
        System.out.println("Test insertVertex:");
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        System.out.println("Số lượng đỉnh hiện tại: " + graph.numVertices()); // Kỳ vọng: 3

        // **Test insertEdge**
        System.out.println("\nTest insertEdge:");
        graph.insertEdge(0, 1, 5); // A-B với trọng số 5
        graph.insertEdge(1, 2, 10); // B-C với trọng số 10
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
