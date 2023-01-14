package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_9466 {

  static ArrayList<Integer> isTeam;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(st.nextToken());

    for (int test = 0; test < T; test++) { //테스트 케이스
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());

      int[] student = new int[n + 1];

      isTeam = new ArrayList<>();
      visited = new boolean[n + 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {  //배열에 저장
        int x = Integer.parseInt(st.nextToken());
        student[i] = x;
      }

//      System.out.println(student);

      for (int i = 1; i <= n; i++) {
        ArrayList<Integer> road = new ArrayList<>();  //경로 저장
        if (visited[i]) {  //이미 방문한 학생이면 continue
          continue;
        }
        DFS(i, student, road);
      }

      sb.append(n - isTeam.size() + "\n");

    } //test

    System.out.print(sb);
  } //main

  static void DFS(int num, int[] student, ArrayList<Integer> road) {

    visited[num] = true; //방문 처리
    road.add(num);  //경로에 num 저장
    int next = student[num]; //num이 찍은 학생

//    System.out.println("road " + road);
    if (visited[next]) {  //이미 방문한 학생이면 return
      if (road.contains(next)) {  //next가 road에 있으면 팀(사이클) 형성
        //road에 있는 next의 인덱스 찾아서, 거기부터 끝까지 isTeam에 추가, 방문처리
        int idx = road.indexOf(next);
        for (int i = idx; i < road.size(); i++) {
           //경로에 있는 숫자
          isTeam.add(road.get(i));
        }
//      System.out.println(isTeam);
      }
      return; //끝내기
    }


//    System.out.println(Arrays.toString(visited) + "\n" + next);

    DFS(next, student, road);  //next로 DFS

  } //DFS

} //class