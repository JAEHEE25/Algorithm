package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_4963 {
  static int[][] land;
  static boolean[][] visited;
  static BufferedReader br;
  static StringTokenizer st;
  static int w, h;
  static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  };

  public static void main(String[] args) throws IOException {
    System.setIn(new java.io.FileInputStream("src/Baekjoon/input.txt"));
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) {
        break;
      }
      int answer = solution(w, h);
      sb.append(answer + "\n");
    }

    System.out.print(sb);
  }//main

  static int solution(int w, int h) throws IOException {
    land = new int[h][w];
    visited = new boolean[h][w];

    //그래프 입력받기
    for (int i = 0; i < h; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        land[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (land[i][j] == 1 && !visited[i][j]) {
          BFS(i, j);
          cnt++;
        }
      }
    }

    return cnt;
  } //solution

  static void BFS(int i, int j) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(i, j));
    visited[i][j] = true;

    int[] dx = {1, 0, 0, -1, 1, -1, 1, -1};
    int[] dy = {0, 1, -1, 0, 1, 1, -1, -1};

    while (!queue.isEmpty()) {
      Node poll = queue.poll();

      for (int k = 0; k < 8; k++) {
        int nx = poll.x + dx[k];
        int ny = poll.y + dy[k];
        if (nx < 0 || ny >= w || nx >= h || ny < 0) {  //범위 벗어남
          continue;
        }

        if (land[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new Node(nx, ny));
        }
      }
    }


  }//BFS

}//class
