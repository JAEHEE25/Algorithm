package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468 {
    static int N;
    static int[][] area;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, area[i][j]);
            }
        }

        for (int height = max; height >= 0; height--) {
            cnt = 0;
            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && area[i][j] > height) {
                        DFS(i, j, height);
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);

    }//main

    static void DFS(int x, int y, int height) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (!visit[nx][ny] && area[nx][ny] > height) {
                DFS(nx, ny, height);
            }

        }
    }
}//class
