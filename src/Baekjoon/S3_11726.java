package Baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class S3_11726 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n + 1];
    //dp[n] = 타일로 채우는 방법 수를 10007로 나눈 나머지

    for (int i = 1; i <= n; i++) {
      if (i == 1) dp[1] = 1;
      else if (i == 2) dp[2] = 2;
      else {
        dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
      }
    }

    System.out.println(dp[n]);

    /*
    점화식
    2 빼거나
    1 빼거나
    결국 1, 2로 어케 쪼개냐

    n=1 1
    n=2 11, 2 -> 2
    n=3, 111 하나 + 2,1 + 1,2 -> dp[n-2] == dp[1] +  dp[n-1]
     */

  }//main

}//class
