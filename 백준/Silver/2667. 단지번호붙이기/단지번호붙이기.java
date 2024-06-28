import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visit;
    static int houseCnt;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int totalCnt = 0; //총 단지수
        List<Integer> houseList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && map[i][j] == '1') {
                    houseCnt = 0;
                    dfs(i, j);
                    totalCnt++;
                    houseList.add(houseCnt);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalCnt).append("\n");
        
        Collections.sort(houseList);
        for (int h : houseList) sb.append(h).append("\n");

        System.out.println(sb);
    }//main

    static void dfs(int x, int y) {
        visit[x][y] = true;
        houseCnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] || map[nx][ny] == '0') continue;

            dfs(nx, ny);
        }
    }
}//class