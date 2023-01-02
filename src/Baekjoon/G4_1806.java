package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1806 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    //수열 길이 n, 합이 s 이상
    int n = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
    //수열 입력 받기
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    //구간합 만들기
    int[] sum = new int[n+1];
    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i-1] + arr[i-1];
    }

    System.out.println(Arrays.toString(sum));

    int x = 0;
    int start = 0;
    int end;
    int cnt = 1;

    while (x < n) {
      end = start + 1 + x;

      if (end <= n) {
        int result = sum[end] - sum[start];

        System.out.println("시작" + start + "끝" + end);
        start++;
        System.out.println("결과" + result);

        if (result >= s) {
          System.out.println("답" + result);
          System.out.println("개수" + cnt);
          sb.append(cnt);
          break;
        }
      }
      else {
        System.out.println("여기");
        start = 0;
        x++;
        cnt++;
      }

    }

    if (x >= n) {
      cnt = 0;
      sb.append(cnt);
    }

    System.out.print(sb);
  }

}
