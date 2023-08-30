package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_10507 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());  //실제 공부한 날 수
      int p = Integer.parseInt(st.nextToken());  //추가 체크 가능한 날

      int[] study = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        study[i] = Integer.parseInt(st.nextToken());
      }


    }
  }//main

  /*
  빈 숫자 개수 1 0 3 0
  p = 2
  3 4 5 6 7 -> 했을 때의 길이는 5
  8 9 10 11 -> 길이 4

  dp[추가한 숫자의 인덱스] = 길이
  dp[0] -> 3 = 0
  dp[1] -> 5 =
  dp[

  다음거가 +1 숫자인지 확인해서
  dp[0] -> 1 = 4 (다음이 0이라서)
  dp[1] -> 0 = 패스
  dp[2] -> 3 =

   */
}//class
