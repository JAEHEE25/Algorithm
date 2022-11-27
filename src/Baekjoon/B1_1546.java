package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B1_1546 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] grade = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    // 공백으로 나눠서 배열에 입력
    for (int i = 0; i < N; i++) {
      grade[i] = Integer.parseInt(st.nextToken());
    }

    int M = grade[0];
    double[] grade_d = new double[N];
    double sum = 0;

    // 최댓값 구하기
    for (int g : grade) {
      if (g > M) {
        M = g;
      }
    }
    // 점수 배열 변환
    for (int i = 0; i < N; i++) {
      grade_d[i] = (double) grade[i] / M * 100;
    }
    // 합 구하기
    for (double d : grade_d) {
      sum += d;
    }
    System.out.println(sum / N);

//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//    int A[] = new int[N];
//    for (int i = 0; i < N; i++) {
//      A[i] = sc.nextInt();
//    }
//    long sum = 0;
//    long max = 0;
//    for (int i = 0; i < N; i++) {
//      if (A[i] > max) max = A[i];
//      sum += A[i];
//    }
//    System.out.println(sum * 100.0 / max / N);
  }
}
