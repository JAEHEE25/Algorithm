import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] cards = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards);

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int target = Integer.parseInt(st.nextToken());
      boolean find = false;

      int start = 0;
      int end = cards.length - 1;
      int mid;

      while (end >= start) {
        mid = (start + end) / 2;

        if (target > cards[mid]) { //오른쪽
          start = mid + 1;
        } else if (target < cards[mid]) { //왼쪽
          end = mid - 1;
        } else { //찾음
          find = true;
          break;
        }
      }
      if (find) {
        sb.append("1 ");
      } else {
        sb.append("0 ");
      }
    }

    System.out.print(sb);
    
  }//main

}//class
