import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] close;
	static int[] dist;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //노드 개수
		int M = Integer.parseInt(st.nextToken()); //에지 개수
		int K = Integer.parseInt(st.nextToken()); //정답 거리
		int X = Integer.parseInt(st.nextToken()); //출발

		//초기화
		dist = new int[N + 1];
		visit = new boolean[N + 1];
		close = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			close[i] = new ArrayList<>();
		}

		//인접 리스트 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			close[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		BFS(X);

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] == K)
				answer.append(i).append("\n");
		}
		if (String.valueOf(answer).equals(""))
			System.out.println("-1");
		else
			System.out.println(answer);
	}//main

	static void BFS(int X) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(X);
		visit[X] = true;

		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			for (Integer next : close[now]) {
				if (!visit[next]) {
					visit[next] = true;
					dist[next] = dist[now] + 1;
					queue.add(next);
				}
			}
		}
	}
}//class