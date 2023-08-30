package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9095 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());

      int[] dp = new int[n + 1];
      //dp[숫자] = 숫자를 1,2,3의 합으로 나타내는 방법의 수

      dp[1] = 1;

      for (int i = 2; i <= n; i++) {
        if (i == 2) dp[i] = 2;
        else if (i == 3) dp[i] = 4;
        else {
          dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
      }

      sb.append(dp[n]).append("\n");

      /*
      점화식
      n=1 1
      n=2 (1,1) (2) -> 2
      n=3 (1,1,1) (2,1) (1,2) (3) -> 4

      4
      3 빼면 dp[1] -> 4   1111 211 121 31
      2 빼면 dp[2] -> 2   112 22
      1 빼면 dp[3] -> 1   13
      */


    }//test

    System.out.println(sb);

  }//main

}//class
