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

//    PriorityQueue<Long> positive = new PriorityQueue<>();
//    PriorityQueue<Long> negative = new PriorityQueue<>();

    ArrayList<Long> list = new ArrayList<>();

    //x가 0이면 -> 절댓값 가장 작은 값(여러개면 음수) 출력 후 제거
    //절댓값 기준 정렬하고 -3 -1 0 3 5, 앞뒤 두개가 절댓값 같으면 앞에거 출력
    //안 같으면 둘 중에 절댓값 작은거 출력


    for (int i = 0; i < n; i++) {
      long x = Long.parseLong(br.readLine());

      if (x == 0) {
        if (list.size() == 1) {
          sb.append("0" + "\n");
        } else {
          int idx = list.indexOf(0L);
//          System.out.println(list);

          int next = idx + 1;
          int prev = idx - 1;
          if (idx == 0) {
          sb.append(list.get(next) + "\n");
//            System.out.println("1 " + list.get(next));
            list.remove(list.get(next));
          } else if (idx == list.size() - 1) {
          sb.append(list.get(prev) + "\n");
//            System.out.println("2 " + list.get(prev));
            list.remove(list.get(prev));
          } else {
            if (Math.abs(list.get(prev)) <= Math.abs(list.get(next))) {
//              System.out.println("3 " + list.get(prev));
              sb.append(list.get(prev) + "\n");
              list.remove(list.get(prev));
            }
            else {
//              System.out.println("4 " + list.get(next));
              sb.append(list.get(next) + "\n");
              list.remove(list.get(next));
            }
          }
        }
      } else {  //x가 0이 아니면 값 추가
        list.add(x);
      }
    }

    System.out.print(sb);

  } //main
} //class
