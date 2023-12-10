package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] energy = new int[N + 1];
        int[] joy = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
            joy[i] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[N + 1][100];
        //dp[사람][체력] = 기쁨

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100; j++) {
                dp[i][j] = dp[i - 1][j]; //이전 행 저장
                if (j >= energy[i]) { //체력을 수용 가능하다면
                    dp[i][j] = Math.max(dp[i - 1][j - energy[i]] + joy[i], dp[i][j]);
                }
            }
        }
        System.out.println(dp[N][99]);
    }//main
}//class

/*
56
21 -> 77
24 -> 101
34 -> 135
135
 */
