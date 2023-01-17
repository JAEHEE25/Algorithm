package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
  static int n;
  static int m;
  static String[][] maze;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    maze = new String[n][m];

    for (int i = 0; i < n; i++) {  //미로 저장
      maze[i] = br.readLine().split("");
      System.out.println(Arrays.toString(maze[i]));
    }

  }//BFS

}//class
