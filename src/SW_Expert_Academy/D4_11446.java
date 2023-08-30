package SW_Expert_Academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_11446 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int test_case = 1; test_case <= T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      long m = Long.parseLong(st.nextToken());
      long[] kindCnt = new long[n];

      long min = 1;
      long max = 1;

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        kindCnt[i] = Long.parseLong(st.nextToken());

        if (kindCnt[i] > max) {
          max = kindCnt[i];
        }
      }

      while (min <= max) {
        long mid = (min + max) / 2;
        int cnt = 0;

        for (long num : kindCnt) {
          cnt += num / mid;
        }

        if (cnt < m) {
          max = mid - 1;
        } else {
          min = mid + 1;
        }

      }

      System.out.println("#" + test_case + " " + max + "\n");
    }
  }//main

}//class
