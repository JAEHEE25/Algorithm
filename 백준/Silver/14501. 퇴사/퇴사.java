import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2]; //dp[일] = 일까지의 최대 수익

		for (int i = 1; i <= N; i++) {
			int next = i + T[i]; //다음 상담 날
			if (next <= N + 1) {//다음 상담 날에 회사에 없음
				dp[next] = Math.max(dp[i] + P[i], dp[next]); //오늘 상담 이어서 하는 수익 vs 기존 계산해놨던 최대 수익
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]); //최대 수익 갱신
		}
		System.out.println(dp[N + 1]);
	}//main

}//class
