package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1987 {
    static int R;
    static int C;
    static char[][] arr;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[27];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
//        System.out.println(Arrays.deepToString(arr));

        visit[arr[0][0] - 65] = true;
        System.out.println(recur(0, 0, 1));

    }//main

    static int recur(int x, int y, int cnt) {
//        System.out.println("x: " + x + " y: " + y + " letter: " + arr[x][y] +  " cnt: " + cnt);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) { //범위 벗어나면
                continue;
            }
//            System.out.println("-> nx: " + nx + " ny: " + ny + " letter: " + arr[nx][ny]);
            int idx = arr[nx][ny] - 65;
            if (visit[idx]) { //방문했으면
//                System.out.println("이미 방문");
                continue;
            }
            visit[idx] = true;
            recur(nx, ny, cnt + 1);
//            System.out.println(idx + "false 처리");
            visit[idx] = false;
        }
//        System.out.println("답 " + cnt);
        answer = Math.max(cnt, answer);
        return answer;
    }//cnt
}//class
