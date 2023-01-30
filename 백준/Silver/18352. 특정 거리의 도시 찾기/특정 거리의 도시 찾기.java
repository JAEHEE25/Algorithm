import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static boolean[] visited;
  static ArrayList<Integer>[] close;
  static int[] distance;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    close = new ArrayList[n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i <= n; i++) {  //초기화
      ArrayList<Integer> list = new ArrayList<>();
      close[i] = list;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      close[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
    }

    distance = new int[n+1];
    BFS(x);

    for (int i = 1; i <= n; i++) {
      if (distance[i] == k) {
        sb.append(i + "\n");
      }
    }
    if (sb.length() == 0) {
      sb.append("-1");
    }
    System.out.print(sb);
  }//main

  static void BFS(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;
    distance[start] = 0;

    while (!queue.isEmpty()) {
      int poll = queue.poll();

      for (int i : close[poll]) {
        if (!visited[i]) {
          queue.add(i);
          visited[i] = true;
          distance[i] = distance[poll] + 1;
        }
      }
    }

  }//BFS

}//class
