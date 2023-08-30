package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class S3_9461 {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    long T = sc.nextInt();

    for (long t = 0; t < T; t++) {
      int n = sc.nextInt();
      long[] dp = new long[n + 1];
      //dp[삼각형 개수] = 정삼각형 변의 길이

      for (int i = 1; i <= n; i++) {
        if (i == 1 || i == 2 || i == 3) dp[i] = 1;
        else {
          dp[i] = dp[i-3] + dp[i-2];
        }
      }

      sb.append(dp[n] + "\n");

    }//test

    /*
    점화식
    1개면 1
    2개면 1
    3개면 1
    4개면 dp[n-3] + dp[n-2] 2
    5개면 dp[n-3] + dp[n-2] 2
    6개면 1+2,2 -> 3
    7개면 2+2, 3 -> 4
    8 2+3, 4
     */

    System.out.print(sb);

  }//main

}//class
