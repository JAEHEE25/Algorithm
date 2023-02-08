package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S1_2667 {
  static char[][] map;
  static boolean[][] visited;
  static int n;
  static int division;
  static int house = 0;
  static ArrayList<Integer> houseList;
  static int[] dx = {1, 0, 0, -1};
  static int[] dy = {0, 1, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    map = new char[n][n];
    visited = new boolean[n][n];

    division = 0;
    houseList = new ArrayList<>();


    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j] && map[i][j] == '1') {
          DFS(i, j);
          houseList.add(house);
          house = 0;
          division++;
        }
      }
    }

    sb.append(division + "\n");

    Collections.sort(houseList);

    for (int h : houseList) {
      sb.append(h + "\n");
    }

    System.out.print(sb);
  }//main

  static void DFS(int x, int y) {
    visited[x][y] = true;
    house++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
        continue;
      }

      if (!visited[nx][ny] && map[nx][ny] == '1') {
        DFS(nx, ny);
      }
    }



  }//DFS
}//class
