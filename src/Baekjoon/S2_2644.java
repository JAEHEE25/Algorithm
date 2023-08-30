package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S2_2644 {
    static ArrayList<Integer>[] relation;
    static boolean[] visited;
    static int cnt;
    static boolean isAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //전체 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); //두 사람
        int y = Integer.parseInt(st.nextToken());

        relation = new ArrayList[n+1]; //관계 배열
        visited = new boolean[n + 1]; //방문 배열

        for (int i = 1; i <= n; i++) { //초기화
            ArrayList<Integer> list = new ArrayList<>();
            relation[i] = list;
        }

        int m = Integer.parseInt(br.readLine()); //관계 개수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            relation[p].add(q);
            relation[q].add(p);
        }

        System.out.println(Arrays.toString(relation));

        cnt = -1;
        isAnswer = false;
        DFS(x, y);

        if (!isAnswer) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }//main

    static void DFS(int num, int y) {
        System.out.println("num " + num );
        if (isAnswer) return;
        visited[num] = true;
        cnt++;
        System.out.println("cnt " + cnt);
        if (num == y) {
            isAnswer = true;
            System.out.println(isAnswer);
        }

        for (int close : relation[num]) {
            System.out.println("num " + num + " close " + close);
            if (visited[close]) continue;
            DFS(close, y);

            if (!isAnswer) cnt--;
        }
    }//DFS
}//class

/*
12
7 6
11
1 2
1 3
2 7
2 8
2 9
4 5
4 6
8 10
10 11
11 12
12 4
 */
