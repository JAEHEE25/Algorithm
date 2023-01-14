package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_1012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    for (int test = 0; test < T; test++) { //테스트 케이스
      ArrayList<Integer>[] close = new ArrayList[m*n];

      int[] dx = {1, 0 ,0, -1};
      int[] dy = {0, 1, -1, 0};

      for (int i = 0; i < m * n; i++) {
        ArrayList<Integer> list = new ArrayList<>();
        close[i] = list;
      }

      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

      }

    }

  } //main

  public void DFS() {

  }

} //class
