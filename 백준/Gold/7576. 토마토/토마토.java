import java.io.*;
import java.util.*;

class Tomato {
  int x;
  int y;

  public Tomato(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Main {

  static Queue<Tomato> queue;
  static int[][] tomato;
  static boolean[][] visited;
  static int m;
  static int n;

  public static void main(String[] args) throws IOException {
    System.out.println(Solution());
  }//main

  static int Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    tomato = new int[n][m];
    visited = new boolean[n][m];

    boolean isAllRipe = true;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        tomato[i][j] = Integer.parseInt(st.nextToken());

        if (tomato[i][j] == 0) {
          isAllRipe = false;
        }
      }
    }

    queue = new LinkedList<>();

    if (isAllRipe) return 0;    //이미 모두 익은 경우 0

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (tomato[i][j] == 1 && !visited[i][j]) {
          queue.add(new Tomato(i, j));
          visited[i][j] = true;
        }
      }
    }

    BFS();
    int answer = 0;

    for (int i = 0; i < n; i++) {  //모두 안익으면 -1
      for (int j = 0; j < m; j++) {
        if (tomato[i][j] > answer) {
          answer = tomato[i][j];
        }

        if (tomato[i][j] == 0) {
          isAllRipe = true;
        }
      }
    }

    if (isAllRipe) return -1;

    return answer - 1;
  }//Solution

  static void BFS() {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    while (!queue.isEmpty()) {
      Tomato poll = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = poll.x + dx[i];
        int ny = poll.y + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m){
          continue;
        }

        if (visited[nx][ny]) {
          continue;
        }

        if (tomato[nx][ny] == 0) {
          tomato[nx][ny] = tomato[poll.x][poll.y] + 1;
          queue.add(new Tomato(nx, ny));
          visited[nx][ny] = true;
        }
      }
    }
  }//BFS

}//class
