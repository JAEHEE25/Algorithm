package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//다른 점이 뭘까...옆에 있는 코드랑...
public class G4_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int length = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    length = Math.max(length, dp[i]);
                }
            }
        }

        System.out.println(length);

        Stack<Integer> answer = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if (dp[i] == length) {
                answer.push(arr[i]);
                length--;
            }
        }

        while (!answer.isEmpty()) {
            System.out.print(answer.pop() + " ");
        }

    }//main

}//class
