import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken()); //이미 가진 랜선 개수
    int n = Integer.parseInt(st.nextToken()); //필요한 랜선 개수

    long[] lan = new long[k];
    long max = 0;
    for (int i = 0; i < k; i++) {
      lan[i] = Long.parseLong(br.readLine());
      if (lan[i] > max) {
        max = lan[i];
      }
    }

    long min = 1;

    while (max >= min) {
      long mid = (max + min) / 2;
      long cnt = 0;

      for (long l : lan) {
        cnt += l / mid;
      }

      if (cnt < n) { //길이 줄여야함
        max = mid - 1;
      } else {  //길이 늘려야함
        min = mid + 1;
      }
    }

    System.out.println(max);

  }//main
}//class
