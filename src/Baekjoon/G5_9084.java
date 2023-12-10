package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            int[] dp = new int[M + 1];
            //dp[동전 값] = 방법 수

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (j > coins[i]) {
                        dp[j] = dp[j] + dp[j - coins[i]];
                    } else if (j == coins[i]){
                        dp[j]++;
                    }
                }
                System.out.println(Arrays.toString(dp));
            }

        }

    }//main
}//class

/*
1
2
1 5
10
 */