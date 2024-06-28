import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int K;
    static int[][] paper;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int area = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        paper = new int[M][N];
        visit = new boolean[M][N];
        int cnt = 0;
        ArrayList<Integer> areas = new ArrayList<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int luy = Integer.parseInt(st.nextToken());
            int lux = Integer.parseInt(st.nextToken());
            int rdy = Integer.parseInt(st.nextToken());
            int rdx = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if ((i >= lux && i < rdx) && (j >= luy && j < rdy)) {
                        paper[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && paper[i][j] != 1) {
                    DFS(i, j);
                    cnt++;
                    areas.add(area);
                    area = 0;
                }
            }
        }
        Collections.sort(areas);

        StringBuilder answer = new StringBuilder();
        answer.append(cnt).append("\n");

        for (int a : areas) {
            answer.append(a).append(" ");
        }

        System.out.println(answer);
    }//main

    static void DFS(int x, int y) {
        visit[x][y] = true;
        area++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }

            if (!visit[nx][ny] && paper[nx][ny] != 1) {
                DFS(nx, ny);
            }
        }
    }//DFS

}//class
