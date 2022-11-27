package Baekjoon;

import java.util.Scanner;

public class S3_11659 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int N = in.nextInt();
    int M = in.nextInt();

    int[] input = new int[N];
    int[] sum = new int[N];
    int[] result = new int[M];

    for (int i = 0; i < N; i++) {
      input[i] = in.nextInt();

      if (i == 0) {
        sum[i] = input[i];
      } else {
        sum[i] = sum[i-1] + input[i];
      }
    }

    for (int x = 0; x < M; x++) {
      int i = in.nextInt() - 1;
      int j = in.nextInt() - 1;

      if (i == 0) {
        result[x] = sum[j];
      } else {
        result[x] = sum[j] - sum[i - 1];
      }
    }

    for (int x = 0; x < M ; x++) {
      System.out.println(result[x]);
    }
  }
}
