import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

    }//test

    System.out.println(sb);

  }//main

}//class
