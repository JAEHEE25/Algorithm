import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] cabbages;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

            cabbages= new int[M][N];
            visit = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                Arrays.fill(cabbages[i], 0);
            }

			for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[x][y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j] && cabbages[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            answer.append(cnt).append("\n");
		}

        System.out.println(answer);
	}//main

    public static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && cabbages[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}//class