import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] picture;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;
    static char start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            picture[i] = br.readLine().toCharArray();
        }

        //색약 아닌 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    start = picture[i][j];
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.print(cnt + " ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (picture[i][j] == 'R')
                    picture[i][j] = 'G';
            }
        }
        visit = new boolean[N][N];
        cnt = 0;

        //색약인 사람
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    start = picture[i][j];
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }//main

    static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || picture[nx][ny] != start) continue;

            dfs(nx, ny);
        }
    }
}//class