package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_11728 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < m; i++) {
      list.add(Integer.parseInt(st.nextToken()));
    }
    Collections.sort(list);

    for (int l : list) {
      bw.write(l + " ");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}