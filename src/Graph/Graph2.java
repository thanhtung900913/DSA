package Graph;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Graph2 {
    public static String[] vertices;
    public static int[][] adj;

    static class Edges {
        String source;
        String destination;
        double weight;

        public Edges(String s, String d, double w) {
            this.source = s;
            this.destination = d;
            this.weight = w;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }

        @Override
        public String toString() {
            return this.source + "--" + this.weight + "-->" + this.destination;
        }
    }

    public static void mstPrim(String u) {
        // To do
        Set<String> inMST = new HashSet<>();
        Set<String> outMST = new HashSet<>();
        inMST.add(u);
        for(String v: vertices){
            if(!u.equals(v)){
                outMST.add(v);
            }
        }
        List<Edges> mst = new ArrayList<>();
        while (!outMST.isEmpty()){
            Edges e = findMinEdge(inMST, outMST);
            inMST.add(e.destination);
            outMST.remove(e.destination);
            mst.add(e);
        }
        for (Edges e: mst) {
            System.out.println(e);
        }
    }
    public static int vertexToIndex(String u){
        for (int i = 0; i < adj.length; i++) {
            if(u.equals(vertices[i])){
                return i;
            }
        }
        return -1;
    }
    public static Edges findMinEdge(Set<String> inMST, Set<String> outMST){
        String source = "";
        String destination = "";
        int minWeight = -1;
        for(String u: inMST){
            for(String v: outMST){
                int i = vertexToIndex(u);
                int j = vertexToIndex(v);
                if(adj[i][j] > 0){
                    if(minWeight == -1 || minWeight > adj[i][j]){
                        source = u;
                        destination = v;
                        minWeight = adj[i][j];
                    }
                }
            }
        }
        return new Edges(source, destination, minWeight);
    }






    public static void mstKruskal() {
        // To do
        Map<String, String> parents = new HashMap<>();
        List<Edges> edges = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if(adj[i][j] > 0){
                    edges.add(new Edges(vertices[i], vertices[j], adj[i][j]));
                }
            }
            parents.put(vertices[i],vertices[i] );
        }

        edges.sort(Comparator.comparingDouble(e->e.weight));
        List<Edges> mst = new ArrayList<>();
        for (Edges e: edges) {
            String root1 = findParent(parents, e.source);
            String root2 = findParent(parents, e.destination);
            if(!root2.equals(root1)){
                mst.add(e);
                union(root1, root2, parents);
            }
            if(mst.size() == adj.length-1){
                break;
            }
        }
        for (Edges e: mst){
            System.out.println(e);
        }
    }
    public static String findParent(Map<String, String> parents, String u){
        if(!parents.get(u).equals(u)){
            return findParent(parents, parents.get(u));
        }
        return parents.get(u);
    }
    public static void union(String root1, String root2, Map<String, String> parents){
        parents.put(root1, root2);
    }


    public static void loadMatrixFromFile(String fileName) {
        try {
            Scanner reader = new Scanner(new FileReader(fileName));
            int n = Integer.parseInt(reader.nextLine().strip());
            vertices = new String[n];
            adj = new int[n][n];
            for (int i = 0; i < n; i++) {
                String v = reader.nextLine();
                vertices[i] = v;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = reader.nextInt();
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public static void djikstra(int[][] a, int x, int y) {
//        int n = a.length; // Số đỉnh trong đồ thị
//        int[] dist = new int[n]; // Khoảng cách ngắn nhất từ đỉnh nguồn đến các đỉnh
//        boolean[] visited = new boolean[n]; // Đánh dấu đỉnh đã thăm
//        int[] prev = new int[n]; // Lưu đỉnh trước đó để truy vết đường đi
//
//        // Khởi tạo giá trị ban đầu
//        Arrays.fill(dist, Integer.MAX_VALUE); // Ban đầu, khoảng cách đến tất cả các đỉnh là "vô cực"
//        Arrays.fill(prev, -1); // Đỉnh trước đó chưa xác định
//        dist[x] = 0; // Khoảng cách từ đỉnh nguồn đến chính nó là 0
//
//        // Hàng đợi ưu tiên để chọn đỉnh có khoảng cách nhỏ nhất
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
//        pq.add(x); // Thêm đỉnh nguồn vào hàng đợi
//
//        // Thuật toán Dijkstra
//        while (!pq.isEmpty()) {
//            int u = pq.poll(); // Lấy đỉnh có khoảng cách nhỏ nhất
//            if (u == y) { // Nếu đã đạt đến đỉnh đích, dừng
//                break;
//            }
//            if (!visited[u]) {
//                visited[u] = true; // Đánh dấu đỉnh đã thăm
//                for (int v = 0; v < n; v++) {
//                    if (a[u][v] != 0 && !visited[v]) { // Nếu có cạnh nối và đỉnh chưa thăm
//                        int newDist = dist[u] + a[u][v]; // Tính khoảng cách mới
//                        if (newDist < dist[v]) { // Nếu khoảng cách mới nhỏ hơn khoảng cách cũ
//                            dist[v] = newDist; // Cập nhật khoảng cách
//                            prev[v] = u; // Ghi lại đỉnh trước đó
//                            pq.add(v); // Thêm đỉnh vào hàng đợi ưu tiên
//                        }
//                    }
//                }
//            }
//        }
//
//        // Kiểm tra nếu không có đường đi
//        if (dist[y] == Integer.MAX_VALUE) {
//            System.out.println("Không có đường đi từ đỉnh " + x + " đến đỉnh " + y);
//            return;
//        }
//
//        // In khoảng cách ngắn nhất
//        System.out.println("Khoảng cách ngắn nhất từ " + x + " đến " + y + ": " + dist[y]);
//
//        // Truy vết đường đi từ x đến y
//        LinkedList<Integer> path = new LinkedList<>();
//        for (int at = y; at != -1; at = prev[at]) {
//            path.addFirst(at);
//        }
//
//        // In đường đi
//        System.out.print("Đường đi: ");
//        for (int i = 0; i < path.size(); i++) {
//            System.out.print(path.get(i));
//            if (i < path.size() - 1) {
//                System.out.print(" -> ");
//            }
//        }
//        System.out.println("Prev: ");
//        for (int i = y; i != -1; i = prev[i]) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        loadMatrixFromFile("E:\\java\\DSA\\src\\Graph\\graph2.txt");
        System.out.println("MST using Prim's Algorithm:");
        mstPrim("0");
        System.out.println("\nMST using Kruskal's Algorithm:");
        mstKruskal();
//        // Nhập đỉnh bắt đầu và đỉnh kết thúc từ người dùng
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập đỉnh bắt đầu (1-based index): ");
//        int start = scanner.nextInt();
//        System.out.print("Nhập đỉnh kết thúc (1-based index): ");
//        int end = scanner.nextInt();
//
//        djikstra(adj, start, end);
    }
}
