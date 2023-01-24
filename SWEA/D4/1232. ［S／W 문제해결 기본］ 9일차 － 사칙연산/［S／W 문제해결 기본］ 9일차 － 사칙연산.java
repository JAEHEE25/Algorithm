import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution {
  static int n;
  static String[] tree;
  static Stack<String> stack;
  static int result;
  static int[] left;
  static int[] right;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    stack = new Stack<>();

    for (int test_case = 1; test_case <= 10; test_case++) {
      n = Integer.parseInt(br.readLine());
      tree = new String[n + 1];
      left = new int[n + 1];
      right = new int[n + 1];

      result = 0;
      stack.clear();

      for (int i = 1; i <= n; i++) {  //트리 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        tree[node] = st.nextToken();

        if (st.hasMoreTokens()) {
          left[i] = Integer.parseInt(st.nextToken());
          right[i] = Integer.parseInt(st.nextToken());
        }
      }
      postOrder(1);
      sb.append("#" + test_case + " " + result + "\n");
    }
    System.out.print(sb);

  }//main

  static void postOrder(int idx) {
    if (idx > n || idx == 0) {
      return;
    }
    postOrder(left[idx]);
    postOrder(right[idx]);

    if (tree[idx].charAt(0) < '0' || tree[idx].charAt(0) > '9') {  //연산자라면
      int y = Integer.parseInt(stack.pop());
      int x = Integer.parseInt(stack.pop());
      result = calculate(x, tree[idx], y);
      stack.push(String.valueOf(result));
      return;
    }
    stack.push(tree[idx]);
  }//postOrder

  static int calculate(int x, String c, int y) {  //기호에 따라 연산한 결과 반환
    if (c.equals("+")) {
      return x + y;
    } else if (c.equals("-")) {
      return x - y;
    } else if (c.equals("*")) {
      return x * y;
    } else {
      return x / y;
    }
  }//calculate

}//class
