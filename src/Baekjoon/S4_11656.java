package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class S4_11656 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    ArrayList<String> strList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
      strList.add(str.substring(i));
    }
    Collections.sort(strList);

    for (String s : strList) {
      sb.append(s + "\n");
    }
    System.out.print(sb);
  }
}
