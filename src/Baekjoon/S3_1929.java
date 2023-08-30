package Baekjoon;


import java.util.Scanner;

public class S3_1929 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[] num = new int[n+1];
    StringBuilder sb = new StringBuilder();

    //배열 초기화
    for (int i = 2; i <= n; i++) {
      num[i] = i;
    }

    //숫자 돌기
    for (int i = 2; i <= n; i++) {
      if (num[i] == 0) continue;  //이미 지워진 수일 경우 continue
      for (int j = i + i; j <= n; j += i) {  //배수일 경우
        num[j] = 0;  //0으로 만들어서 지워줌
      }
    }

    //출력
    for (int i = m; i <= n; i++) {
      if (num[i] != 0) {
        sb.append(num[i] + "\n");
      }
    }

    System.out.print(sb);
  }//main

}//class
