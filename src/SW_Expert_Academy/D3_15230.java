package SW_Expert_Academy;

import java.util.Scanner;
import java.io.FileInputStream;

class D3_15230
{
  public static void main(String args[]) throws Exception
  {
    //System.setIn(new FileInputStream("res/input.txt"));

    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt();

    char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    int cnt;

    for (int test_case = 1; test_case <= T; test_case++)
    {
      char[] test = sc.next().toCharArray();
      cnt = 0;

      for (int i = 0; i < test.length; i++) {
        if (test[i] != alpha[i]) {
          break;
        }
        cnt++;
      }
      System.out.println("#" + test_case + " " + cnt);
    }
  }
}