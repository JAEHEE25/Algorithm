package Baekjoon;

import java.io.*;
import java.util.*;

public class S1_1149 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  //집의 수

    int[][] cost = new int[n][3];
    //cost[집번호][색] = 비용

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int R = 0;
    int G = 1;
    int B = 2;

    for (int i = 1; i < n; i++) {
      cost[i][R] = cost[i][R] + Math.min(cost[i-1][G], cost[i-1][B]);
      cost[i][G] = cost[i][G] + Math.min(cost[i-1][R], cost[i-1][B]);
      cost[i][B] = cost[i][B] + Math.min(cost[i-1][R], cost[i-1][G]);
    }

    System.out.println(Math.min(Math.min(cost[n - 1][R], cost[n - 1][G]), cost[n - 1][B]));
    /*
    집을 다 돌면서 비용을 갱신하는 건데
    아예 더한걸로 계산을 하는 거
     */

  }//main


}//class
