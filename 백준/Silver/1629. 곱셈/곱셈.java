import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long C = sc.nextLong();

		System.out.println(recur(A, B, C));
	}//main

	public static long recur(long A, long B, long C) {
		if (B == 1)	return A % C;

		long res = recur(A, B / 2, C);

		if (B % 2 == 1) {
			return (res * res % C) * A % C;
		}
		return res * res % C;
        
	}
}//class