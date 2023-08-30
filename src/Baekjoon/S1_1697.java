package Baekjoon;

import java.io.*;
import java.util.*;

public class S1_1697 {

  static Queue<Integer> queue;
  static int[] count = new int[100001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int soobin = Integer.parseInt(st.nextToken());
    int sister = Integer.parseInt(st.nextToken());

    if (soobin == sister) {
      System.out.println(0);
    } else {
      BFS(soobin, sister);
    }

  }//main

  static void BFS(int soobin, int sister) {
    queue = new LinkedList<>();
    queue.add(soobin);
    count[soobin] = 1;

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int i = 0; i < 3; i++) {
        int value;

        if (i == 0) {
          value = now - 1;
        } else if (i == 1) {
          value = now + 1;
        } else {
          value = now * 2;
        }

        if (value == sister) {
          System.out.println(count[now]);
          return;
        }

        if (value >= 0 && value < count.length && count[value] == 0) {
          queue.add(value);
          count[value] = count[now] + 1;
        }
      }
    }
  }//BFS

}//class