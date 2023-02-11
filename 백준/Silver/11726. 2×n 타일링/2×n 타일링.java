import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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

  }//main

}//class
