import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());

    ArrayList<Integer>[] close = new ArrayList[n+1];
    boolean[] virus = new boolean[n+1];

    for (int i = 1; i <= n; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      close[i] = list;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      close[x].add(y);
      close[y].add(x);
    }
//    System.out.println(Arrays.toString(close));

    System.out.println(DFS(1, close, virus));

  }//main

  static int DFS(int num, ArrayList<Integer>[] close, boolean[] virus) {
    virus[num] = true;
    cnt++;

//    System.out.println(Arrays.toString(virus));
//    System.out.println(cnt);
    for (int c : close[num]) {
      if (!virus[c]) {
        DFS(c, close, virus);
      }
    }
    return cnt-1;
  }

}//class
