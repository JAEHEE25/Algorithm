package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G5_10026 {
    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] picture;
    static boolean[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt + " ");
        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'G') {
                    picture[i][j] = 'R';
                }
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    DFS(i, j);
                    cnt++;
                }
            }

        }

        System.out.print(cnt);
    } //main

    static void DFS(int x, int y) {
        visit[x][y] = true;
        char letter = picture[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            char nextLetter = picture[nx][ny];
            if (!visit[nx][ny] && letter == nextLetter) {
                DFS(nx, ny);
            }
        }
    }//DFS
} //class
