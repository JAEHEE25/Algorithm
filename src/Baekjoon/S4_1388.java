package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1388 {

  static char[][] floor;
  static boolean[][] visited;
  static int[] d = {-1, 1};
  static int n;
  static int m;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    floor = new char[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      floor[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (visited[i][j]) continue;
        cnt++;
        DFS(i, j);
      }
    }
    System.out.println(cnt);
  }//main

  static void DFS(int x, int y) {
    visited[x][y] = true;

    for (int dd : d) {
      int nx = x + dd;
      int ny = y + dd;

      if (floor[x][y] == '|') {
        if (nx < 0 || nx >= n || visited[nx][y]) continue;
        if (floor[nx][y] == '|') {
          DFS(nx, y);
        }
      } else {
        if (ny < 0 || ny >= m || visited[x][ny]) continue;
        if (floor[x][ny] == '-') {
          DFS(x, ny);
        }
      }
    }

  }//DFS
}//class
