package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1_2775 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < T; t++) {
      int k = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());

      int[][] dp = new int[k + 1][n + 1];
      //dp[a층][n호] = a층의 1호부터 n호까지 사람들 수의 합 == dp[a-1]의 1부터 n까지의 합

      for (int i = 1; i <= n; i++) {
        dp[0][i] = i;
      }

      for (int i = 1; i <= k; i++) {
        for (int j = 1; j <= n; j++) {
          if (j == 1) dp[i][j] = dp[i-1][1];
          else {
            dp[i][j] = dp[i][j-1] + dp[i-1][j];
          }
        }
      }

      sb.append(dp[k][n]).append("\n");

    } //test

    /*
    점화식
    k가 1, n이 3
    dp[0]은 6, 1호에 1, 2호에 2, 3호에 3
    dp[1][1]에는 0층의 1호 -> dp[k-1][1]
    dp[1][2]에는 0층의 1호부터 2호까지의 -> dp[1][1] + dp[k-1][2]
    dp[1]층의 3호에는 0층의 1부터 3호까지의 합만큼 산다.
    dp[2]층의 3호에는 1층의 1부터 3호까지의 합만큼 산다.
     */

    System.out.print(sb);
  } //main

} //class
