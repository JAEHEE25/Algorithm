package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S4_1940 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //n, m, ans
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int ans = 0;

    //재료 번호 배열
    List<Integer> num = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      num.add(Integer.parseInt(st.nextToken()));
    }

    //정렬
    Collections.sort(num);

    //투 포인터
    int start = 0;
    int end = n - 1;

    while (start < end) {
      int sum = num.get(start) + num.get(end);
      if (sum == m) {
        ans++;
        end--;
      } else if (sum < m)
        start++;
      else
        end--;
    }
    System.out.println(ans);
  }
}

//    int end = 1;
//
//    while (end <= n-1) {
////      System.out.println(start + " " + end + " ");
//
//      int sum = num.get(start) + num.get(end);
//
//      if (sum < m) {
//        end++;
//      } else if (sum == m) {
//        ans++;
//        end++;
//      } else {
//        start++;
//        end = start + 1;
//      }
//      if (end >= n) {
//        start++;
//        end = start + 1;
//      }
//    }
//    System.out.println(ans);
//  }
//}
