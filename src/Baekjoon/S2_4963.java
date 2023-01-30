package Baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_4963 {
  static int[][] land;
  static boolean[] visited;
  static ArrayList<Integer> close;

  public static void main(String[] args) throws IOException {
    System.setIn(new java.io.FileInputStream("src/Baekjoon/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int w = Integer.parseInt(st.nextToken());
    int h = Integer.parseInt(st.nextToken());
    land = new int[w][h];

    for (int i = 0; i < h; i++) {  //그래프
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        land[j][i] = Integer.parseInt(st.nextToken());
      }
    }

    int[] dx = {1, 0, 0, -1, 1, -1, 1, -1};
    int[] dy = {0, 1, -1, 0, -1, 1, 1, -1};

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        for (int k = 0; k < 8; k++) {
          System.out.println(i + " " + j);
          System.out.println((j + dx[k]) + " " + (i + dy[k]));
          if (j + dx[k] < 0 || j + dx[k] > w || i + dy[k] > h || i + dy[k] < 0) {  //범위 벗어남

            continue;
          }
          if (land[i + dy[k]][j + dx[k]] == 1) {
            System.out.println("인접");
          }

//          if (land[i][j + 1] == 1 || land[i][j - 1] == 1 || land[i + 1][j] == 1
//              || land[i - 1][j] == 1 || land[i - 1][j - 1] == 1 || land[i + 1][j + 1] == 1
//              || land[i - 1][j + 1] == 1 || land[i + 1][j - 1] == 1) {
//          }
        }

      }
    }




  }//main

  static void BFS() {

  }

}//class


/*
1 1
0
2 2
0 1
1 0
 */
