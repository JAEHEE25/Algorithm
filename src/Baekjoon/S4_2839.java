package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class S4_2839 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = 0;

    while (true) {
      if (n % 5 == 0) {
        System.out.println(n / 5 + cnt);
        break;
      }
      if (n < 0) {
        System.out.println(-1);
        break;
      }
      n -= 3;
      cnt++;
    }
  }//main

}//class
