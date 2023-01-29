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

public class S2_18352 {

  static boolean[] visited;
  static ArrayList<Integer>[] close;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    System.setIn(new java.io.FileInputStream("src/Baekjoon/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    close = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i <= n; i++) {  //초기화
      ArrayList<Integer> list = new ArrayList<>();
      close[i] = list;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      close[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    }

    Queue<Integer> queue = new LinkedList<>();
    ArrayList<Integer> answer = new ArrayList<>();
    BFS(x, k, queue, answer);

    Collections.sort(answer);

    for (int a : answer) {
      sb.append(a + "\n");
    }
    System.out.print(sb);
  }//main

  static void BFS(int start, int dis, Queue<Integer> queue, ArrayList<Integer> answer) {
    queue.add(start);
    visited[start] = true;
    int cnt = 0;

    while (!queue.isEmpty()) {
      int poll = queue.poll();

      if (close[poll].isEmpty()) {
        continue;
      }

      cnt++;

      for (int i : close[poll]) {
        if (visited[i]) {
          continue;
        }
        queue.add(i);
        visited[i] = true;

        if (cnt == dis) {
          answer.add(i);
        }
      }

      if (cnt == dis) {
        return;
      }
    }

    sb.append("-1");


  }//BFS

}//class
