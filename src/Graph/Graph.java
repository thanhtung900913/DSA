package Graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    public static String[] vertices;
    public static int[][] adj;
    public static void loadMatrixFromFile(String fileName){
        try{
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
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void printAdjList(){
        for (int i = 0; i < adj.length; i++) {
            System.out.print(vertices[i]);
            for (int j = 0; j < adj.length; j++) {
                if(adj[i][j] != 0){
                    System.out.print("->"+vertices[j]);
                }
            }
            System.out.println();
        }
    }

    public static void dfs(int start){
        boolean[] visited = new boolean[adj.length];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        visited[start] = true;
        System.out.println("DFS: ");
        while (!s.isEmpty()){
            int cur = s.pop();
            System.out.print(vertices[cur]+"->");
            for (int i = 0; i < adj.length; i++) {
                if(adj[cur][i] != 0 && visited[i] == false){
                    s.push(i);
                    visited[i] =true;
                }
            }
        }
        System.out.println();
    }
    public static void bfs(int start){
        boolean[] visted = new boolean[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visted[start] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            System.out.print(vertices[cur] + ", ");
            for (int i = 0; i < adj.length; i++) {
                if(adj[cur][i] != 0 && visted[i] == false){
                    q.add(i);
                    visted[i] = true;
                }
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        loadMatrixFromFile("E:\\java\\DSA\\src\\Graph\\graph.txt");
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
        printAdjList();
        dfs(0);
        bfs(0);

    }

}
