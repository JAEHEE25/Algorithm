import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  //집의 수

    int[][] cost = new int[n][3];
    //cost[집번호][색] = 비용

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int R = 0;
    int G = 1;
    int B = 2;

    for (int i = 1; i < n; i++) {
      cost[i][R] = cost[i][R] + Math.min(cost[i-1][G], cost[i-1][B]);
      cost[i][G] = cost[i][G] + Math.min(cost[i-1][R], cost[i-1][B]);
      cost[i][B] = cost[i][B] + Math.min(cost[i-1][R], cost[i-1][G]);
    }

    System.out.println(Math.min(Math.min(cost[n - 1][R], cost[n - 1][G]), cost[n - 1][B]));

  }//main


}//class
