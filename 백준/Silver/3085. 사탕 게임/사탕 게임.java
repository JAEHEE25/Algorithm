
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] candies;
	static boolean[][] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		candies = new char[N][N];
		for (int i = 0; i < N; i++) {
			candies[i] = br.readLine().toCharArray();
		}
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				checkCloseCandies(i, j);
				visit[i][j] = true; //교환했던 사탕 방문 처리
			}
		}
		System.out.println(answer);
	}

	static void checkCloseCandies(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[nx][ny]) {
				if (candies[x][y] != candies[nx][ny]) { //인접한 사탕의 색이 다르다면
					changeCandies(x, y, nx, ny); //사탕 서로 교환
					answer = Math.max(answer, countSameCandies()); //최대 사탕 개수 세기
					changeCandies(nx, ny, x, y); //사탕 원위치
				}
			}
		}
	}

	static void changeCandies(int px, int py, int nx, int ny) { //사탕의 위치를 바꾼다
		char prevCandy = candies[px][py];
		candies[px][py] = candies[nx][ny];
		candies[nx][ny] = prevCandy;
	}

	static int countSameCandies() { //열/행에서 같은 색 사탕 개수 최대 세기
		int max = 0;

		//열 기준 세기
		for (int i = 0; i < N; i++) {
			char prev = candies[0][i]; //각 열의 첫 번째 사탕
			int count = 1;
			for (int j = 1; j < N; j++) { //행을 바꾼다
				if (prev == candies[j][i]) { //같은 색이라면
					count++;
				} else {
					prev = candies[j][i];
					max = Math.max(max, count);
					count = 1;
				}
			}
			max = Math.max(max, count);
		}

		//행 기준 세기
		for (int i = 0; i < N; i++) {
			char prev = candies[i][0]; //각 행의 첫 번째 사탕
			int count = 1;
			for (int j = 1; j < N; j++) { //열을 바꾼다
				if (prev == candies[i][j]) { //같은 색이라면
					count++;
				} else {
					prev = candies[i][j];
					max = Math.max(max, count);
					count = 1;
				}
			}
			max = Math.max(max, count);
		}

		return max;
	}
}//class

/*
다른 색이 인접한 두 칸 -> 서로 교환 -> 모두 같은 색으로 이루어진 가장 긴 행 또는 열의 사탕 개수

 */