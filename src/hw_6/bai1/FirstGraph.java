package hw_6.bai1;

import java.util.*;

public class FirstGraph implements Graph{
    private int n; // Số đỉnh
    private int[][] adj;
    private String[] V;

    public FirstGraph(int maxV){
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
                if(adj[i][j] == 1 ){
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
                if(adj[i][j] == 1){
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
        if(adj[uI][uV] == 1){
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
    public void insertEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
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
}
