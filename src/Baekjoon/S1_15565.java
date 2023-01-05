package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1_15565 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //총 인형 개수 n, 라이언의 최소 개수 k
    int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

    //인형 배열
    int[] dolls = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      dolls[i] = Integer.parseInt(st.nextToken());
    }

    //1의 개수 인덱스
    ArrayList<Integer> one = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (dolls[i] == 1) {
        one.add(i);
      }
    }

    int start = 0;
    int end;
    int min = 10000000;

//    System.out.println(one);

    for (int i = start; i < one.size() - k + 1; i++) {
      end = start + k - 1;
//      System.out.println(start + " " + end);
      min = Math.min(min, one.get(end) - one.get(start) + 1);
      start++;
    }

    //없으면 -1
    if (one.size() < k) System.out.println(-1);
    else System.out.println(min);
  }

}
