import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] place = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			place[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(place); //정렬

        int answer = 1;
		int taped = place[0] + (L - 1);
		for (int i = 1; i < N; i++) {
            if (place[i] > taped) { //안 막아지는 곳
                answer++;
                taped = place[i] + (L - 1);
            }
		}

        System.out.println(answer);
	}//main
}//class