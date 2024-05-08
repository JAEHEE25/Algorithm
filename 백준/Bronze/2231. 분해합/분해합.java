import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < N; i++) {
			int sum = i;
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				sum += str.charAt(j) - 48;
			}

			if (sum == N) {
				answer = i;
				break;
			}
		}
        System.out.println(answer);
	}//main
}//class