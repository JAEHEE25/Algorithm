import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] heights = new int[9];
		int total = 0;
		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(br.readLine());
			total += heights[i];
		}

		Arrays.sort(heights);

		int a = 0;
		int b = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i != j) {
					int add = heights[i] + heights[j];
					if (total - add == 100) {
						a = i;
						b = j;
						break;
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			if (i == a || i == b) continue;
			System.out.println(heights[i]);
		}

		br.close();
	}

}