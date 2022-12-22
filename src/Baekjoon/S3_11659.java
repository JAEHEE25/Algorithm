package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S3_11659 {
  public static void main(String[] args) throws IOException {
//    Scanner in = new Scanner(System.in);
//
//    int N = in.nextInt();
//    int M = in.nextInt();
//
//    int[] input = new int[N];
//    int[] sum = new int[N];
//    int[] result = new int[M];
//
//    for (int i = 0; i < N; i++) {
//      input[i] = in.nextInt();
//
//      if (i == 0) {
//        sum[i] = input[i];
//      } else {
//        sum[i] = sum[i-1] + input[i];
//      }
//    }
//
//    for (int x = 0; x < M; x++) {
//      int i = in.nextInt() - 1;
//      int j = in.nextInt() - 1;
//
//      if (i == 0) {
//        result[x] = sum[j];
//      } else {
//        result[x] = sum[j] - sum[i - 1];
//      }
//    }
//
//    for (int x = 0; x < M ; x++) {
//      System.out.println(result[x]);
//    }

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    int suNo = Integer.parseInt(stringTokenizer.nextToken());   // 데이터 개수, 5
    int quizNo = Integer.parseInt(stringTokenizer.nextToken());   // 질의 개수, 3

    long[] S = new long[suNo + 1];   // 1 더해서 6개의 원소를 가진 배열 생성

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    for (int i = 1; i <= suNo; i++) {      // 1부터 시작해서
      S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());   // 바로 받으면서 합 배열 생성
    }

    for (int q = 0; q < quizNo; q++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      int i = Integer.parseInt(stringTokenizer.nextToken());
      int j = Integer.parseInt(stringTokenizer.nextToken());
      System.out.println(S[j] - S[i - 1]);   // 구간 합 구하기
    }
  }
}
