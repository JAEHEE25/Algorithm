package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_11660 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    //n, m 입력
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<int[]> sumList = new ArrayList<>();
    int[] sum;

    //행렬 입력
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int[] arr : matrix) {
      //합배열 만들기
      sum = new int[n+1];
      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i-1] + arr[i-1];
      }
      sumList.add(sum);
    }

    //구해야하는 합배열
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int result = 0;

      for (int x = x1-1; x <= x2-1; x++) {
        int[] rowSum = sumList.get(x);
        result += rowSum[y2] - rowSum[y1-1];
      }
      sb.append(result + "\n");
    }
    System.out.print(sb);
  }
}
