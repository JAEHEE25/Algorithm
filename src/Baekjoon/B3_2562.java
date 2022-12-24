package Baekjoon;

import java.util.Scanner;

public class B3_2562 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] arr = new int[9];

    for (int i = 0; i < 9; i++) {
      arr[i] = in.nextInt();
    }

    int max = arr[0];
    int idx = 0;

    for (int i = 0; i < 9; i++) {
      if (arr[i] >= max) {
        max = arr[i];
        idx = i + 1;
      }
    }

    System.out.println(max);
    System.out.println(idx);
  }
}
