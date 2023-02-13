import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);


    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      int num = Integer.parseInt(st.nextToken());
      boolean find = false;

      int start = 0;
      int end = arr.length - 1;

      while (end >= start) {
        int mid = (start + end) / 2;

        if (num == arr[mid]) {  //찾음
          find = true;
          break;
        } else if (num > arr[mid]) { //오른쪽에 있다
          start = mid + 1;
        } else {  //왼쪽에 있다
          end = mid - 1;
        }
      }
      if (find) sb.append("1\n");
      else sb.append("0\n");
    }



    System.out.print(sb);

  }//main


}//class
