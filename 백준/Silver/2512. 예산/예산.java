import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] costs = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		long high = 0;
		long total = 0;
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, costs[i]);
			total += costs[i];
		}
		long M = Long.parseLong(br.readLine());
		long low = 0;

		if (total > M) {
			//이분 탐색
			while (low + 1 < high) {
				long mid = (low + high) / 2;
				total = 0;

				//total 계산
				for (int cost : costs) {
					total += cost > mid ? mid : cost;
				}

				if (total <= M) {
					low = mid;
				} else {
					high = mid;
				}
			}
            System.out.println(low);
        } else {
            System.out.println(high);
        }

	}//main
}//class