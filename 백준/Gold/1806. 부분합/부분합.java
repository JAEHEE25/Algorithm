import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }
        System.out.println(solution(N, S, sum));
    }//main

    static int solution(int N, int S, int[] sum) {
        int length = Integer.MAX_VALUE;
        int left = 1;
        int right = 1;

        while (left <= N && right <= N) {
            int result = sum[right] - sum[left - 1];
            if (result >= S) {
                length = Math.min(right - left + 1, length);
                left++;
            } else {
                right++;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
}//class