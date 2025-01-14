package hw_6.bai4;


import java.util.*;

public class FourthGraph implements Graph {
    private int n; // Số đỉnh
    private int[][] adj;
    private String[] V;

    public FourthGraph(int maxV){
        this.adj = new int[maxV][maxV];
        this.V = new String[maxV];
        this.n = 0;
    }
    @Override
    public int numVertices() {
        return n;
    }

    @Override
    public Iterator vertices() {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(V[i]);
        }
        return list.iterator();
    }

    @Override
    public int numEdges() {
        int num = 0;
        for (int i = 0; i < adj.length; i++) {
            for (int j = i; j < adj.length; j++) {
                if(adj[i][j] != 0 ){
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public Iterator edges() {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < adj.length; i++){
            for (int j = i; j < adj.length; j++) {
                if(adj[i][j] != 0){
                    list.add(V[i]+V[j]);
                }
            }
        }
        return list.iterator();
    }

    @Override
    public void getEdge(String u, String v) {
        int uI = Arrays.asList(V).indexOf(u);
        int uV = Arrays.asList(V).indexOf(v);
        if(adj[uI][uV] != 0){
            System.out.println(uI + ":" + uV);
        }else {
            System.out.println("NULL");
        }
    }

    @Override
    public int[] endVertices(int e) {
        return new int[0];
    }

    @Override
    public int opposite(int v, int e) {
        return 0;
    }

    @Override
    public int outDegree(String v) {
        return 0;
    }

    @Override
    public int inDegree(int v) {
        return 0;
    }

    @Override
    public Iterator outgoingEdges(int v) {
        return null;
    }

    @Override
    public Iterator incomingEdges(int v) {
        return null;
    }

    @Override
    public void insertVertex(String x) {
        V[n] = x;
        n++;
    }

    @Override
    public void insertEdge(int u, int v, int w) {
        adj[u][v] = w;
        adj[v][u] = w;
    }

    @Override
    public void removeVertex(String v) {
        int idx = Arrays.asList(V).indexOf(v);
        for (int i = idx; i < adj.length-1; i++) {
            V[i] = V[i+1];
        }
        V[adj.length-1] = null;
        n--;
        for (int i = 0; i < adj.length; i++) {
            adj[idx][i] = 0;
            adj[i][idx] = 0;
        }
    }

    @Override
    public void removeEdge(int u, int v) {
        adj[u][v] = 0;
        adj[v][u] = 0;
    }
    public void printMatrix(){
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[n]; // Mảng kiểm tra đỉnh đã thăm
        Stack<Integer> stack = new Stack<>(); // Sử dụng stack cho DFS

        stack.push(startVertex);
        visited[startVertex] = true;

        System.out.print("DFS traversal: ");
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(V[current] + " "); // In đỉnh hiện tại

            // Thêm các đỉnh kề chưa thăm vào stack
            for (int i = 0; i < n; i++) {
                if (adj[current][i] != 0 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public void bfs(int startVertex) {
        boolean[] visited = new boolean[n]; // Mảng kiểm tra đỉnh đã thăm
        Queue<Integer> queue = new LinkedList<>(); // Sử dụng queue cho BFS

        queue.add(startVertex);
        visited[startVertex] = true;

        System.out.print("BFS traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(V[current] + " "); // In đỉnh hiện tại

            // Thêm các đỉnh kề chưa thăm vào queue
            for (int i = 0; i < n; i++) {
                if (adj[current][i] != 0 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
    // dijkstra
    public void dijkstra(int start, int end) {
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int[] prev = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            if (dist[u] == Integer.MAX_VALUE) break;

            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (adj[u][v] != 0 && dist[u] + adj[u][v] < dist[v]) {
                    dist[v] = dist[u] + adj[u][v];
                    prev[v] = u;
                }
            }
        }

        System.out.print("Shortest path from " + V[start] + " to " + V[end] + ": ");
        if (dist[end] == Integer.MAX_VALUE) {
            System.out.println("No path.");
            return;
        }

        List<String> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(V[at]);
        }
        Collections.reverse(path);
        System.out.println(String.join(" -> ", path) + " (Distance: " + dist[end] + ")");
    }

    //  Đường đi và chu trình Hamilton
    public void hamiltonianCycle() {
        int[] path = new int[n];
        Arrays.fill(path, -1);
        path[0] = 0; // Bắt đầu từ đỉnh 0

        if (!hamiltonianCycleUtil(path, 1)) {
            System.out.println("No Hamiltonian Cycle found.");
        } else {
            System.out.print("Hamiltonian Cycle: ");
            for (int vertex : path) {
                System.out.print(V[vertex] + " -> ");
            }
            System.out.println(V[path[0]]);
        }
    }

    private boolean hamiltonianCycleUtil(int[] path, int pos) {
        if (pos == n) {
            return adj[path[pos - 1]][path[0]] != 0;
        }

        for (int v = 1; v < n; v++) {
            if (isSafe(v, path, pos)) {
                path[pos] = v;

                if (hamiltonianCycleUtil(path, pos + 1)) return true;

                path[pos] = -1;
            }
        }
        return false;
    }

    private boolean isSafe(int v, int[] path, int pos) {
        if (adj[path[pos - 1]][v] == 0) return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v) return false;
        }

        return true;
    }
    // Đường đi và chu trình Euler
    public void eulerianCycle() {
        if (!isEulerian()) {
            System.out.println("Graph is not Eulerian.");
            return;
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adj[i][j] > 0) degree[i]++;
            }
        }

        stack.push(0);
        while (!stack.isEmpty()) {
            int u = stack.peek();
            boolean found = false;
            for (int v = 0; v < n; v++) {
                if (adj[u][v] > 0) {
                    stack.push(v);
                    adj[u][v]--;
                    adj[v][u]--;
                    found = true;
                    break;
                }
            }
            if (!found) path.add(stack.pop());
        }

        System.out.print("Eulerian Cycle: ");
        for (int vertex : path) {
            System.out.print(V[vertex] + " -> ");
        }
        System.out.println(V[path.get(0)]);
    }

    private boolean isEulerian() {
        int odd = 0;
        for (int i = 0; i < n; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                if (adj[i][j] > 0) degree++;
            }
            if (degree % 2 != 0) odd++;
        }
        return odd == 0;
    }
    // Cây bao trùm tối thiểu
    public void primMST() {
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] mstSet = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (adj[u][v] != 0 && !mstSet[v] && adj[u][v] < key[v]) {
                    key[v] = adj[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Prim's MST:");
        for (int i = 1; i < n; i++) {
            System.out.println(V[parent[i]] + " - " + V[i] + " (Weight: " + adj[i][parent[i]] + ")");
        }
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < n; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    // Tô màu đồ thị
    public void graphColoring() {
        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean[] available = new boolean[n];

        for (int u = 1; u < n; u++) {
            Arrays.fill(available, true);

            for (int v = 0; v < n; v++) {
                if (adj[u][v] != 0 && result[v] != -1) {
                    available[result[v]] = false;
                }
            }

            int color;
            for (color = 0; color < n; color++) {
                if (available[color]) break;
            }

            result[u] = color;
        }

        System.out.println("Vertex Coloring:");
        for (int u = 0; u < n; u++) {
            System.out.println(V[u] + " -> Color " + result[u]);
        }
    }


}