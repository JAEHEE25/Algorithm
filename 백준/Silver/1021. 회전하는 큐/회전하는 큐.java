import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.add(i + 1);
		}

		int[] input = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for (int i = 0; i < input.length; i++) {
			if (queue.indexOf(input[i]) <= queue.size() / 2) { //왼쪽에서 가는게 더 짧으면
				while (!queue.get(0).equals(input[i])) {
                    queue.add(queue.get(0));
				    queue.remove(0);
					answer++;
				}
			} else {
				while (!queue.get(0).equals(input[i])) {
                    queue.add(0, queue.get(queue.size() - 1));
                    queue.remove(queue.size() - 1);
			        answer++;
				}
			}

			queue.remove(0);
		}

		System.out.println(answer);

	}//main
}//class