package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_1874 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> input = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      input.add(Integer.parseInt(br.readLine()));
    }

    ArrayList<Integer> answer = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int idx = 0;
    int num = 1;

    while (idx < n) {
      if (input.get(idx) < num) {
        answer.add(stack.pop());
        sb.append("-").append("\n");
        idx++;
        continue;
      }

      stack.push(num);
      sb.append("+").append("\n");
      num++;
    }

    if (!answer.equals(input) || !stack.isEmpty()) {
      sb = new StringBuilder("NO");
    }

    System.out.print(sb);
  }
}
