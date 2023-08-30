import java.util.*;

public class Main {

  static StringBuilder sb = new StringBuilder();
  static int N, M;
  static int[] arr;
  static boolean[] visited;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt();
    M = sc.nextInt();

    visited = new boolean[N + 1];
    arr = new int[M + 1];

    DFS(0);
    System.out.print(sb);
  }

  private static void DFS(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        arr[depth] = i;
        DFS(depth + 1);
        visited[i] = false;
      }
    }
  }
}