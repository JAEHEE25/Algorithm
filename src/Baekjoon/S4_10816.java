package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_10816 {

  static int[] cards;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    //카드 배열 입력 받기
    cards = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards);  //카드 배열 정렬

    //target 입력받아서 처리
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st.nextToken());
      sb.append(upperBound(target) - lowerBound(target)).append(" ");  //target의 개수 출력
    }
    System.out.println(sb);
  }//main

  static int lowerBound(int target) {  //하한: target 이상의 값을 처음 만나는 위치
    int low = 0;
    int high = cards.length;

    while (high > low) {
      int mid = (low + high) / 2;

      if (cards[mid] >= target) {  //mid 값이 target 이상
        high = mid;
      } else {  //mid 값이 target보다 작음
        low = mid + 1;
      }
    }
    return low;
  }//lower

  static int upperBound(int target) {  //상한: target 초과의 값을 처음 만나는 위치
    int low = 0;
    int high = cards.length;

    while (high > low) {
      int mid = (low + high) / 2;

      if (cards[mid] > target) { //mid 값이 target 초과
        high = mid;
      } else { //mid 값이 target 이하
        low = mid + 1;
      }
    }
    return low;
  }//upper
}//class
