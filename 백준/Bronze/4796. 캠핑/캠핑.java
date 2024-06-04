import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 0;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			if (L == 0) break;

            int answer = 0;
            answer += (V / P) * L;
			answer += Math.min(V % P, L);

			T++;
            sb.append("Case ").append(T).append(": ").append(answer).append("\n");
		}

        System.out.println(sb);

	}//main
}//class