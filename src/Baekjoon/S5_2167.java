package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2167 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 2차원 배열 생성
    int[][] arr = new int[n][m];

    for (int p = 0; p < n; p++) {
      st = new StringTokenizer(br.readLine());
      for (int q = 0; q < m; q++) {
        arr[p][q] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());

    for (int num = 0; num < k; num++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken()) - 1;
      int j = Integer.parseInt(st.nextToken()) - 1;
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;
      int sum = 0;

      // i~x, j~y
      for (int p = i; p <= x; p++) {
        for (int q = j; q <= y; q++) {
          sum += arr[p][q];
        }
      }
      System.out.println(sum);
    }
  }
}
