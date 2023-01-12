package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class S1_11286 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());

    PriorityQueue<Long> positive = new PriorityQueue<>();
    PriorityQueue<Long> negative = new PriorityQueue<>(Collections.reverseOrder());

    //x가 0이면 -> 절댓값 가장 작은 값(여러개면 음수) 출력 후 제거
    //p에 양수 추가, n에 음수 추가

    //안 같으면 둘 중에 절댓값 작은거 출력

    for (int i = 0; i < n; i++) {
      long x = Long.parseLong(br.readLine());

      if (x == 0) {  //x가 0일 때
        if (positive.isEmpty() && negative.isEmpty()) {  //둘 다 비어있으면 0 출력
          sb.append("0" + "\n");
        } else {
          if (positive.isEmpty()) sb.append(negative.poll() + "\n");
          else if (negative.isEmpty()) sb.append(positive.poll() + "\n");
          else {
            long absP = Math.abs(positive.peek());
            long absN = Math.abs(negative.peek());
            if (absP == absN) {  //각 맨 앞 비교해서 절댓값 같으면 n 맨앞 출력
              sb.append(negative.poll() + "\n");
            } else {
              if (absP < absN) sb.append(positive.poll() + "\n");
              else sb.append(negative.poll() + "\n");
            }
          }

        }

      } else {  //x가 0이 아닐 때
        if (x < 0) negative.add(x);  //음수
        else positive.add(x);  //양수
      }

    }

    System.out.print(sb);

  } //main
} //class
