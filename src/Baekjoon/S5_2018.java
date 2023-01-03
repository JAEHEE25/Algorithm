package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S5_2018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int start = 1;
    int end = 2;
    int sum;
    int answer = 1;

    while (start < n / 2 + 1) {
      sum = (start + end) * (end - start + 1) / 2;

      if (sum < n) {
        end++;
      }
      else if (sum == n) {
        answer++;
        start++;
        end = start + 1;
      }
      else {
        start++;
        end = start + 1;
      }
    }

    System.out.println(answer);

//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int count = 1;
//    int start_index = 1;
//    int end_index = 1;
//    int sum = 1;
//
//    while (end_index != n) {
//      if (sum == n) {
//        count++;
//        end_index++;
//        sum += end_index;
//      } else if (sum > n) {
//        sum -= start_index;
//        start_index++;
//      } else {
//        end_index++;
//        sum += end_index;
//      }
//    }
//    System.out.println(count);
  }

}
