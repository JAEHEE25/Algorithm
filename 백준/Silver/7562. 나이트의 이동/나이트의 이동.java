import java.io.*;
import java.util.*;;

public class Main {
	static int N;
	static Queue<Chess> queue;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
	static int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
	static StringBuilder answer;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		answer = new StringBuilder();

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());

			queue = new LinkedList<>();
			BFS(nx, ny, tx, ty);

		}

		System.out.println(answer);
	}//main

	static void BFS(int nx, int ny, int tx, int ty) {
		queue.add(new Chess(nx, ny, 0));
		visited[nx][ny] = true;

		while (!queue.isEmpty()) {
			Chess poll = queue.poll();
            
			if (poll.x == tx && poll.y == ty) { //정답
				answer.append(poll.count).append("\n");
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = poll.x + dx[i];
				int nextY = poll.y + dy[i];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
					continue;
				}

				queue.add(new Chess(nextX, nextY, poll.count + 1));
				visited[nextX][nextY] = true;
			}
		}
	}
}

class Chess {
	int x;
	int y;
	int count;

	Chess(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
