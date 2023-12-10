package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        Arrays.sort(arr);

        int start = 0;
        int end = 1;

        while (start < end) {
            int minus = Math.abs(arr[start] - arr[end]);

            if (minus == M) {
                answer = M;
                break;
            } else if (minus > M) {
                answer = Math.min(answer, minus);
                start++;
            } else {
                end++;
            }
        }

        System.out.println(answer);
    }//main
}//class

/*
1 2 3 5 6
 */