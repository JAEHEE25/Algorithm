import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int testcase = 0; testcase < T; testcase++) {
      int I = Integer.parseInt(br.readLine());
      board = new int[I][I];
      visited = new boolean[I][I];

      StringTokenizer st = new StringTokenizer(br.readLine());
      int sx = Integer.parseInt(st.nextToken());
      int sy = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int tx = Integer.parseInt(st.nextToken());
      int ty = Integer.parseInt(st.nextToken());

      BFS(sx, sy, I, tx, ty);

      System.out.println(board[tx][ty]);
    }//test

  }//main

  static void BFS(int sx, int sy, int I, int tx, int ty) {
    int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
    int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
    Queue<Chess> queue = new LinkedList<>();
    queue.add(new Chess(sx, sy));
    visited[sx][sy] = true;

    while (!queue.isEmpty()) {
      Chess poll = queue.poll();

      for (int i = 0; i < 8; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];

        if (nx < 0 || nx >= I || ny < 0 || ny >= I || visited[nx][ny]) {
          continue;
        }

        board[nx][ny] = board[poll.x][poll.y] + 1;

        if (nx == tx && ny == ty) {
          return;
        }

        queue.add(new Chess(nx, ny));
        visited[nx][ny] = true;
      }
    }
  }//BFS

}//class

class Chess {
  public int x;
  public int y;

  public Chess(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
