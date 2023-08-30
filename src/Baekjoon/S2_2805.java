package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2805 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] tree = new int[n];

    long max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      if (tree[i] > max) {
        max = tree[i];
      }
    }

    long min = 0;

    while (min <= max) {
      long height = (min + max) / 2;
      long sum = 0;

      for (int t : tree) {
        if (t <= height) {
          continue;
        }
        sum += (t - height);
      }

      if (sum < m) {
        max = height - 1;
      } else {
        min = height + 1;
      }
    }

    System.out.println(max);

    /*
    최종적으로 구해야하는 것: 높이의 최댓값
    target: height
    가진 나무 길이의 합 m과 비교

    while (min <= max)
    sum
    높이보다 크면 높이로 더하기

    if (sum < m) 너무 작게 자름, 높이 내려야함
      max = height - 1;
    else sum >= m 너무 많이 자름, 높이 올려야함
     min = height + 1;
     */

  }//main
}//class
