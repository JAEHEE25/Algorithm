package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1182 {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] visit;
    static int sum = 1000001;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            backtracking(0, i);
        }
    }//main

    static void backtracking(int idx, int depth) {
        if (sum == S) {
            System.out.println("sum " + sum);
            cnt++;
            System.out.println("cnt " + cnt);
            return;
        }

        if (idx == depth) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                System.out.println(arr[i]);
                backtracking(idx + 1, depth);
                visit[i] = false;
            }
        }
    }//DFS

}//class
