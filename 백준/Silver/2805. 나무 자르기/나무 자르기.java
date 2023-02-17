import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] tree = new int[n];

    long max = 0;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      tree[i] = Integer.parseInt(st.nextToken());
      if (tree[i] > max) {
        max = tree[i];
      }
    }

    long min = 0;

    while (min <= max) {
      long height = (min + max) / 2;
      long sum = 0;

      for (int t : tree) {
        if (t <= height) {
          continue;
        }
        sum += (t - height);
      }

      if (sum < m) {
        max = height - 1;
      } else {
        min = height + 1;
      }
    }

    System.out.println(max);

  }//main
}//class
