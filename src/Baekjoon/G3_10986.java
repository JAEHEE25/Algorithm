package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//하는중
public class G3_10986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    //n, m, cnt
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    int cnt = 0;

    //n개의 수 배열
    ArrayList<Integer> input = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input.add(Integer.parseInt(st.nextToken()));
    }

    //구간합 만들기
    while (n > 0) {
      int[] sum = new int[n + 1];

      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + input.get(i - 1);
      }

      cnt += (int) Arrays.stream(sum).filter(x -> x % m == 0).count() - 1;
      input.remove(0);
      n--;
    }

    sb.append(cnt);
    System.out.print(sb);
  }
}
