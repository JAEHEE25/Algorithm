import java.io.IOException;
import java.util.Scanner;

public class Main {
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

    System.out.print(sb);

  }//main

}//class
