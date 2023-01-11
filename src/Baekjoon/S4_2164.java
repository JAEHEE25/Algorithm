package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4_2164 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    Queue<Integer> card = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      card.add(i);
    }

    for (int i = 0; i < n-1; i++) {
      card.poll();
      card.add(card.poll());
    }

    System.out.println(card.peek());

  }
}
