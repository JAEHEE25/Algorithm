import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());  //지방의 수

    int[] budget = new int[n];  //예산
    int max = 0;  //최댓값
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      budget[i] = Integer.parseInt(st.nextToken());

      if (budget[i] > max) {
        max = budget[i];
      }
    }

    int m = Integer.parseInt(br.readLine());  //총 예산

    int min = 1;

    while (min <= max) {
      int upper = (min + max) / 2;
      int sum = 0;

      for (int b : budget) {
        if (b > upper) {
          sum += upper;
        } else {
          sum += b;
        }
      }

      if (sum > m) {
        max = upper - 1;
      } else {
        min = upper + 1;
      }

    }

    System.out.println(max);

  }//main

}//class
