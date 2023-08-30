package Baekjoon;

import java.io.*;
import java.util.*;

public class G5_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];


        for (int item = 1; item <= N; item++) { //아이템 돌기
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for (int curW = 1; curW <= K; curW++) { //무게 돌기, curW: 현재 무게
                dp[item][curW] = dp[item - 1][curW];
                if (curW - weight >= 0) { //남는 무게가 있을 경우
                    dp[item][curW] = Math.max(dp[item][curW], value + dp[item][curW - weight]);
                }
            }


        }
        System.out.println(dp[N][K]);

    }//main

}//class
