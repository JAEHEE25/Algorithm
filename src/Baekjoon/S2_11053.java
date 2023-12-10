package Baekjoon;

import java.util.*;
import java.io.*;

public class S2_11053 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    int[] dp = new int[N];
    //dp[인덱스] = 수열의 길이
    int answer = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = 1;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      answer = Math.max(answer, dp[i]);
    }

    System.out.println(answer);

  }//main
}//class