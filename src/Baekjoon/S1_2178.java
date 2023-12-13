package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {
    static int N;
    static int M;
    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        BFS();
        System.out.println(answer);
    }//main

    static void BFS() {
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Block poll = queue.poll();

            if (poll.x == N - 1 && poll.y == M - 1) {
                answer = poll.count + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (!visited[nx][ny] && maze[nx][ny] == '1') {
                    queue.add(new Block(nx, ny, poll.count + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}//class

class Block {
    int x;
    int y;
    int count;

    Block(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
