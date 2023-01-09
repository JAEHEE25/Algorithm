package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11724 {
  static ArrayList<Integer>[] close;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    close = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 1; i < n + 1; i++) {
      close[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      close[u].add(v);
      close[v].add(u);
    }

    int cnt = 0;
    for (int i = 1; i < n + 1; i++) {
      if (!visited[i]) {
        cnt++;
        DFS(i);
      }
    }
    System.out.println(cnt);
  }

    static void DFS(int d) {
      if (visited[d]) {
        return;
      }
      visited[d] = true;
      for (int i : close[d]) {
        if (!visited[i]) {
          DFS(i);
        }
      }
    }
  }
