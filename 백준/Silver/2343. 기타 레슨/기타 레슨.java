import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static int low;
	static int high;

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		low = 0;
		high = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			low = Math.max(low, arr[i]);
			high += arr[i];
		}
		System.out.println(bs());
	}//main

	static int bs() {
		while (low < high) {
			int mid = (low + high) / 2;
			int count = getCount(mid);
			if (count > M) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	static int getCount(int size) {
		int count = 0;
		int sum = 0;
		for (int a : arr) {
			if (sum + a > size) {
				sum = 0;
				count++;
			}
			sum += a;
		}
		if (sum != 0) count++;
		return count;
	}

}//class