package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1806 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //n, s
    int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
    int length = n+1;

    //수열
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      if (arr[i] >= s) {
        length = 1;
      }
    }
    int tmp = 0;
    for (int i = 0; i < n; i++) {
      tmp += arr[i];
    }

    if (tmp < s) {
      length = 0;
    } else {
      length = n;
    }

    //투 포인터
    int start = 0;
    int end = 1;
    int sum = arr[start] + arr[end];

    while (true) {
//      System.out.println(start +" "+ end+ " " + sum);
      int L = end - start + 1;
//      System.out.println("시작" + start + " " + end + " " + sum);
      if (sum < s) {
        end++;
        if (end > n-1) {
          break;
        }
        sum += arr[end];
//        System.out.println("작음" + start + " " + end + " " + sum);
      } else {
        if (L < length) {
          length = L;
          sum -= arr[end];
          end -= 1;
          continue;
        }
        sum -= arr[start];
        start++;
//        System.out.println("이상" + start + " " + end + " " + sum + "길이" + length);
      }
    }
    System.out.println(length);
  }
}