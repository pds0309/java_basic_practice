package example.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsProc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        boolean visited[] = new boolean[node + 1];

        int[][] adjArray = new int[node + 1][node + 1];

        for (int i = 0; i < edge; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjArray[v1][v2] = 1;
            adjArray[v2][v1] = 1;
        }

        BFS(start, adjArray, visited);
    }

    public static void BFS(int start, int[][] adjArray, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");
            for (int i = 1; i < adjArray.length; i++) {
                if (adjArray[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}