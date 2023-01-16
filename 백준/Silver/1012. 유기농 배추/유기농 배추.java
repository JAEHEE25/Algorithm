import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int m;
  static int n;
  static int[][] ground;
  static boolean[][] visited;
  static int[] dx = {1, 0 ,0, -1};  //하, 우, 좌, 상
  static int[] dy = {0, 1, -1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    for (int test = 0; test < T; test++) { //테스트 케이스
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      ground = new int[m][n];
      visited = new boolean[m][n];
      int cnt = 0;

      for (int i = 0; i < k; i++) {  //배추 심기
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        ground[x][y] = 1;
      }

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (visited[i][j] || ground[i][j] == 0) {  //이미 방문했거나 값이 0이면 continue
            continue;
          }
          DFS(i, j);
          cnt++;  //탐색이 끝날 때마다 개수 추가
        }
      }

      sb.append(cnt + "\n");
    }
    System.out.print(sb);
  } //main

  static void DFS(int row, int col) {
//    System.out.println("row: " + row + " col: " + col);
    visited[row][col] = true;  //방문 처리

    for (int i = 0; i < 4; i++) {  //상하좌우에 1이 있으면 그 노드에서 DFS
      int next_row = row + dx[i];
      int next_col = col + dy[i];

//      System.out.println("next row: " + next_row + " next col: " + next_col);

      if (next_row < 0 || next_col < 0 || next_row >= m || next_col >= n) {  //범위 벗어나면 continue
        continue;
      }
      if (visited[next_row][next_col]) {  //이미 방문했으면 continue
        continue;
      }
      if (ground[next_row][next_col] == 1) {  //방문하지 않았고 1이면 DFS
        DFS(next_row, next_col);
      }
    }
  } //DFS

} //class
