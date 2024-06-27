import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = N - 1;
        long min = Long.MAX_VALUE;
        long result;
        long[] answer = {0, 0};

        while (low < high) {
			result = solutions[low] + solutions[high];

			if (Math.abs(result) < min) {
				min = Math.abs(result);
				answer[0] = solutions[low];
				answer[1] = solutions[high];
			}

			if (result < 0) low++; //합이 커져야 한다
			else high--; //합이 작아져야 한다

        }

        System.out.println(answer[0] + " " + answer[1]);

	}//main
}//class