import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] waste;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        waste = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            waste[r - 1][c - 1] = 1;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visit[i][j] && waste[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    answer = Math.max(answer, cnt);
                }

            }
        }
        System.out.println(answer);
    }//main

    static void dfs(int x, int y) {
        visit[x][y] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || waste[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}//class