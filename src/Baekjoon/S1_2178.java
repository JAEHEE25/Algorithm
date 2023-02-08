package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
  public int x;
  public int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class S1_2178 {

  static int[][] maze;
  static boolean[][] visited;
  static int n;
  static int m;
  static int cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    maze = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      char[] ch = br.readLine().toCharArray();

      for (int j = 0; j < m; j++) {
        maze[i][j] = ch[j] - '0';
      }
    }

    System.out.println(Arrays.deepToString(maze));

    BFS(0, 0);

    System.out.println(maze[n-1][m-1]);

  }//main

  static void BFS(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    queue.add(new Node(x, y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Node poll = queue.poll();
      cnt++;

      for (int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];

        if (nx >= n || nx < 0 || ny >= m || ny < 0) {
          continue;
        }

        if (!visited[nx][ny] && maze[nx][ny] == 1) {
          queue.add(new Node(nx, ny));
          maze[nx][ny] = maze[poll.x][poll.y] + 1;
          System.out.println(Arrays.deepToString(maze));

          visited[nx][ny] = true;
        }
      }


    }


  }//BFS

}//class
