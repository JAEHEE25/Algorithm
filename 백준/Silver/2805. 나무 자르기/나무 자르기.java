import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
		int high = 0; //최댓값
        st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
			high = Math.max(high, trees[i]);
		}

        int low = 0;
        int H;

        while (low + 1 < high) { //찾는 구간이 1일때까지
            H = (low + high) / 2;
            long sum = 0;

            //sum 구하기
            for (int i = 0; i < N; i++) {
                if (trees[i] > H)
                    sum += (trees[i] - H);
            }

            if (sum >= M) { //sum이 M 이상일 경우(조건을 만족할 경우) -> 포함해서 돌린다.
                low = H;
            } else { //sum이 M보다 작을 경우 -> 포함하지 않는다.
                high = H;
            }
        }
        System.out.println(low);
	}//main
}//class