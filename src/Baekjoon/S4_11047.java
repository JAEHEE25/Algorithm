package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());  //종류
    int k = Integer.parseInt(st.nextToken());  //합

    int[] coin = new int[n];

    for (int i = n-1; i >= 0; i--) {
      coin[i] = Integer.parseInt(br.readLine());
    }

    int cnt = 0;
    for (int c : coin) {
      cnt += k / c;
      k %= c;
    }

    System.out.println(cnt);

  }//main

}//class
