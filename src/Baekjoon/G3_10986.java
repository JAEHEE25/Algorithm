package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class G3_10986 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //n, m, ans
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    long ans = 0;

    //n개의 수 배열
    ArrayList<Integer> input = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      input.add(Integer.parseInt(st.nextToken()));
    }

    //누적합 배열
    long[] sum = new long[n+1];
    for (int i = 1; i <= n; i++) {
      sum[i] = sum[i - 1] + input.get(i-1);
    }

    //나머지 배열
    ArrayList<Long> rest = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      rest.add(sum[i] % m);

    }

    //나머지 배열에 0이 있을 경우 개수 1 더하기
    for (long r: rest) {
      if (r == 0) {
        ans += 1;
      }
    }

    //나머지 배열에서 개수 구하기
    //나머지 배열 중복제거
    List<Long> done = rest.stream().distinct().collect(Collectors.toList());
    for (long d : done) {
      long cnt = Collections.frequency(rest, d);  //배열에서 개수 구하기
      ans += (cnt * (cnt - 1) / 2);
    }
    System.out.println(ans);

//    Scanner sc = new Scanner(System.in);
//    int n = sc.nextInt();
//    int m = sc.nextInt();
//    long[] S = new long[n];
//    long[] C = new long[m];
//    long answer = 0;
//    //바로 입력받아서 합 배열 만들기
//    S[0] = sc.nextInt();
//    for (int i = 1; i <= n; i++) {
//      S[i] = S[i - 1] + sc.nextInt();
//    }
//    for (int i = 0; i < n; i++) {
//      int remainder = (int) (S[i] % m);
//      //구간합 자체가 0일때 정답에 더하기
//      if (remainder == 0) answer++;
//      //나머지에 해당하는 인덱스 개수 카운팅
//      C[remainder]++;
//    }
//    for (int i = 0; i < m; i++) {
//      if (C[i] > 1) {
//        answer += C[i] * (C[i] - 1) / 2;
//      }
//    }
//    System.out.println(answer);
  }
}
