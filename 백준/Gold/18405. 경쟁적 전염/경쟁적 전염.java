import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] tube;
    static int[][] target;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        tube = new int[N][N];
        target = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());

                if (tube[i][j] != 0) target[i][j] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for (int t = 0; t < S; t++) {
            for (int i = 0; i < N; i++) { //바이러스 증식
                for (int j = 0; j < N; j++) {
                    if (target[i][j] == 1) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                            if (target[nx][ny] == 0 && (tube[nx][ny] == 0 ||tube[nx][ny] > tube[i][j])) {
                                tube[nx][ny] = tube[i][j];
                            }
                        }
                        target[i][j] = 2;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tube[i][j] != 0 && target[i][j] != 2) target[i][j] = 1;
                }

            }
        }

        System.out.println(tube[X-1][Y-1]);
    }//main

}//class