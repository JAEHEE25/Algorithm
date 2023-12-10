package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7569 {

    static int M, N, H;
    static int[][][] boxes;
    static boolean[][][] visit;
    static Queue<Tomato> queue;
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dn = {1, -1, 0, 0, 0, 0};
    static int[] dm = {0, 0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        visit = new boolean[H][N][M];

        int answer = 0;
        boolean alreadyRipe = true;
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());

                    if (boxes[i][j][k] != 1) {
                        alreadyRipe = false;
                    } else {
                        queue.add(new Tomato(k, j, i, 0));
                    }
                }
            }
        }

        if (alreadyRipe) {
            answer = 0;
        } else {
            answer = BFS();

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (boxes[i][j][k] == 0) {
                            answer = -1;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }//main

    static int BFS() {
        int count = 0;

        while (!queue.isEmpty()) {
            Tomato cur = queue.poll();

            visit[cur.h][cur.n][cur.m] = true;

            for (int i = 0; i < 6; i++) {
                int nh = cur.h + dh[i];
                int nn = cur.n + dn[i];
                int nm = cur.m + dm[i];

                if (nh >= H || nh < 0 || nn >= N || nn < 0 || nm >= M || nm < 0) { //범위 벗어나면
                    continue;
                }

                if (visit[nh][nn][nm] || boxes[nh][nn][nm] != 0) { //이미 방문 또는 들어있지 않거나 익은 거면
                    continue;
                }

                boxes[nh][nn][nm] = 1;
                queue.add(new Tomato(nm, nn, nh, cur.cnt + 1));
            }
            count = cur.cnt;
        }

        return count;
    }//BFS
}//class

class Tomato {
    public int m;
    public int n;
    public int h;
    public int cnt;

    public Tomato(int m, int n, int h, int cnt) {
        this.m = m;
        this.n = n;
        this.h = h;
        this.cnt = cnt;
    }

}
