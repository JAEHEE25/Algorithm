package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2805 {
  static int[] trees;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    trees = new int[N];

    long max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, trees[i]);
    }

    long min = 0;

    while (min <= max) {
      long mid = (min + max) / 2;
      long totalLength = calculateLength(mid);

      for (int tree : trees) {
        if (tree > mid) {
          totalLength += tree - mid;
        }
      }

      if (totalLength < M) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }

    System.out.println(max);
  }//main


  static long calculateLength(long mid) {
    long totalLength = 0;

    for (int tree : trees) {
      if (tree > mid) {
        totalLength += tree - mid;
      }
    }

    return totalLength;
  }
}//class
