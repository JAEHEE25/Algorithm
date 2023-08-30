package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2512 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  //지방의 수

    int[] budget = new int[n];  //예산
    int max = 0;  //최댓값
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      budget[i] = Integer.parseInt(st.nextToken());

      if (budget[i] > max) {
        max = budget[i];
      }
    }

    int m = Integer.parseInt(br.readLine());  //총 예산

    int min = 1;

    while (min <= max) {
      int upper = (min + max) / 2;
      int sum = 0;

      for (int b : budget) {
        if (b > upper) {
          sum += upper;
        } else {
          sum += b;
        }
      }

      if (sum > m) {
        max = upper - 1;
      } else {
        min = upper + 1;
      }

    }

    System.out.println(min -1);

    /*
    최종적으로 구해야 하는 것: 배정된 예산 중 최댓값
    target: 상한액 == mid
    합을 m이랑 비교

    상한액보다 크면 상한액으로 더함

    while (min <= max)

    if (sum > m) 상한액이 너무 큼, 줄여야함
      max = mid - 1;
    else (sum <= m) 상한액이 너무 작음, 늘려야함
      min = mid + 1;

    return max;

     */


  }//main

}//class
