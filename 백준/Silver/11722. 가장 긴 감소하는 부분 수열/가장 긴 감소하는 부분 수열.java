import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1);  // dp를 1로 초기화
		
		int max = 1;
		for (int i = 1; i < n; i++) {  // LIS 알고리즘
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i]) {  // 감소하는 수열
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);  // 가장 긴 감소하는 수열 길이 갱신
		}
		
		System.out.println(max);
	}
}