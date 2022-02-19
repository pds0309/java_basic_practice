package example.graph;

import java.util.*;

public class BfsList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        boolean visited[] = new boolean[node + 1];

        LinkedList<Integer>[] adjList = new LinkedList[node + 1];

        for (int i = 0; i <= node; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(adjList[i]);
        }

        BFS(start, adjList, visited);
    }

    public static void BFS(int start, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = true;
        queue.add(start);

        while(queue.size() != 0) {
            start = queue.poll();
            System.out.print(start + " ");

            Iterator<Integer> iter = adjList[start].listIterator();
            while(iter.hasNext()) {
                int adj = iter.next();
                if(!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }
}