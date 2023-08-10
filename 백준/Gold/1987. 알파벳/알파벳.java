import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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

        visit[arr[0][0] - 65] = true;
        System.out.println(recur(0, 0, 1));

    }//main

    static int recur(int x, int y, int cnt) {
      
        answer = Math.max(cnt, answer);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= R || ny < 0 || ny >= C) { //범위 벗어나면
                continue;
            }

            int idx = arr[nx][ny] - 65;
            if (visit[idx]) { //방문했으면

                continue;
            }
            visit[idx] = true;
            recur(nx, ny, cnt + 1);

            visit[idx] = false;
        }

        return answer;
    }//cnt
}//class
