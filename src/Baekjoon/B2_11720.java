package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2_11720 {
  public static void main(String[] args) throws IOException {

    Scanner in = new Scanner(System.in);
    int a = in.nextInt();
    String b = in.next();
    int sum = 0;

    for (int i = 0; i < b.length(); i++) {
      int num_b = Integer.parseInt(String.valueOf(b.charAt(i)));
      sum += num_b;
    }
    System.out.println(sum);

//    1. Do it 책 풀이 방법
//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//    String sNum = sc.next();
//    char[] cNum = sNum.toCharArray();
//    int sum = 0;
//    for (int i = 0; i < cNum.length; i++) {
//      sum += cNum[i] - '0';  // 정수형으로 변환
//    }
//    System.out.println(sum);

//    2. BufferedReader로 입력 받기
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int N = Integer.parseInt(br.readLine());
//    char[] numbers = br.readLine().toCharArray();
//    int total = 0;
//
//    for (int i = 0; i < N; i++) {
//      total += Integer.parseInt(String.valueOf(numbers[i]));
//    }
//    System.out.println(total);
  }
}
