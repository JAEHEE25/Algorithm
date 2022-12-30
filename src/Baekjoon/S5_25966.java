package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_25966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //개수 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), q = Integer.parseInt(st.nextToken());

    //행렬 입력
    int[][] matrix = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //쿼리 입력
    for (int c = 0; c < q; c++) {
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      if (first == 0) {
        int k = Integer.parseInt(st.nextToken());
        matrix[i][j] = k;
      }
      else {
        int[] tmp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = tmp;
      }
    }
    //출력
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(matrix[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
