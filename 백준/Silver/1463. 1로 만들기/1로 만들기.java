import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1]; //dp[숫자] = 횟수의 최솟값

        for (int n = 2; n <= N; n++) {
            dp[n] = dp[n - 1] + 1; //1을 뺄 경우의 값
            if (n % 2 == 0) { //2로 나눠지면
                dp[n] = Math.min(dp[n], dp[n / 2] + 1);
            }

            if (n % 3 == 0) { //3으로 나눠지면
                dp[n] = Math.min(dp[n], dp[n / 3] + 1);
            }
        }
        
        System.out.println(dp[N]);
    }//main

}//class