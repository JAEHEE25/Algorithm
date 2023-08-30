package Baekjoon;

import java.util.*;

public class S3_15649 {

  static boolean[] visit;
  static int[] numbers;
  static int N, M;
  static StringBuffer sb;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    visit = new boolean[N+1];
    numbers = new int[M];
    sb = new StringBuffer();

    DFS(0);

  }//main


  static void DFS(int depth) {
    System.out.println(" depth " + depth);
    if (depth == M) { //재귀 끝
      for (int i = 0; i < M; i++) {
        sb.append(numbers[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      System.out.println(" i " + i);
      if (visit[i]) continue;
      visit[i] = true;
      numbers[depth] = i;
      System.out.println(Arrays.toString(numbers));
      System.out.println("depth " + depth);
      DFS(depth + 1);
      System.out.println("false 처리 " + i);
      visit[i] = false;
    }
  }//DFS

}//class