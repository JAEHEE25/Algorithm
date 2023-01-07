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
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());

    ArrayList<Integer> input = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      input.add(Integer.parseInt(st.nextToken()));
    }

    Stack<Integer> stack = new Stack<>();
    ArrayList<Integer> result = new ArrayList<>();

    int num = 1;
    int idx = 0;

    while (result.size() < n) {
      if (num <= input.get(idx)) {
        sb.append("+\n");
        stack.push(num);
        num++;
      } else {
        sb.append("-\n");
        int pop = stack.pop();
        if (pop != input.get(idx)) {
          sb.setLength(0);
          sb.append("NO");
          break;
        } else {
          result.add(pop);
          idx++;
        }
      }
    }
    System.out.print(sb);
  }
}
