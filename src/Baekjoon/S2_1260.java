package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1260 {

  static boolean[] visited;
  static ArrayList<Integer>[] close;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    close = new ArrayList[n + 1];  //인접리스트

    for (int i = 1; i <= n; i++) {  //리스트로 초기화
      ArrayList<Integer> list = new ArrayList<>();
      close[i] = list;
    }

    for (int i = 0; i < m; i++) {  //양방향으로 인접리스트 저장
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      close[y].add(x);
      close[x].add(y);
    }

    for (ArrayList<Integer> c : close) {
      if (c == null) {
        continue;
      }
      Collections.sort(c);
    }

//    System.out.println(Arrays.toString(close));

    //DFS
    visited = new boolean[n+1];
    DFS(v);
    sb.append("\n");

    //BFS
    visited = new boolean[n+1];
    BFS(v);

    //출력
    System.out.print(sb);

  }//main

  static void DFS(int num) {
    visited[num] = true;
    sb.append(num + " ");

    for (int c : close[num]) {
      if (visited[c]) {
        continue;
      }
      DFS(c);
    }
  }//DFS

  static void BFS(int num) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(num);
    visited[num] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      sb.append(now + " ");
      for (int i : close[now]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }

    }
    }//BFS

}//class
