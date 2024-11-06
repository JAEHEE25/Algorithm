import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] close;
	static int[] check;
	static boolean[] visit;
	static boolean isAnswer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		for (int t = 0; t < K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			//초기화
			close = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				close[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				close[x].add(y);
                close[y].add(x);

			}

			check = new int[V + 1];
			visit = new boolean[V + 1];
			isAnswer = true;
			for (int i = 1; i <= V; i++) {
				if (!isAnswer) {
					break;
				}
				if (!visit[i]) check[i] = 1;
				DFS(i);
			}

			if (isAnswer) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}
		System.out.println(sb);
	}//main

	static void DFS(int num) {
		visit[num] = true;

		for (int next : close[num]) {
			if (!visit[next]) {
				check[next] = check[num] == 1 ? 2 : 1;
				DFS(next);
			}

			if (check[num] == check[next]) {
				isAnswer = false;
				return;
			}
		}
	}
}//class