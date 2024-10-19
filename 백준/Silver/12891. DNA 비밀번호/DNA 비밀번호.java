import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //s, p, ans
    int s = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    int ans = 0;

    //dna
    st = new StringTokenizer(br.readLine());
    char[] dna = st.nextToken().toCharArray();

    //acgt 카운트
    int[] acgt = new int[4];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      acgt[i] = Integer.parseInt(st.nextToken());
    }

    //첫번째 부분 문자열
    int start = 0;
    int end = p - 1;
    char[] first_arr = Arrays.copyOfRange(dna, start, end+1);

//    System.out.println(first_arr);

    //부분문자열의 acgt 개수 배열
    int[] cnt = new int[4];

    for (char f : first_arr) {
      count(f, cnt, 1);
    }

    if (cnt[0] >= acgt[0] && cnt[1] >= acgt[1] && cnt[2] >= acgt[2] && cnt[3] >= acgt[3]) {
      ans++;
    }

//    System.out.println(Arrays.toString(cnt));

    while (end + 1 < s) {
      count(dna[start], cnt, -1);
      start++;
      end++;
      //처음과 끝 카운트
      count(dna[end], cnt, 1);
//      System.out.println(dna[start] + " " + dna[end]);
//      System.out.println(Arrays.toString(cnt));

      if (cnt[0] >= acgt[0] && cnt[1] >= acgt[1] && cnt[2] >= acgt[2] && cnt[3] >= acgt[3]) {
        ans++;

      }
    }

    System.out.println(ans);

  }

  static void count(char c, int[] cnt_arr, int add) {
    if (c == 'A') {
      cnt_arr[0] += add;
    } else if (c == 'C') {
      cnt_arr[1] += add;
    } else if (c == 'G') {
      cnt_arr[2] += add;
    } else if (c == 'T') {
      cnt_arr[3] += add;
    }
  }
}