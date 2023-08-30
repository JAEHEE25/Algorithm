package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class S3_1463 {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] dp = new int[n + 1];
    //dp[x] = x에서 1로 만드는 최소 횟수

    dp[1] = 0;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + 1;
      if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
      if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
    }

    System.out.println(dp[n]);

  }//main
}//class
