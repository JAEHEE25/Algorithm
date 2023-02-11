import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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

    System.out.print(sb);
  } //main

} //class
