package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class S3_15652 {
    static int[] arr;
    static boolean[] visit;
    static int[] answer;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visit = new boolean[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        answer = new int[M];
        sb = new StringBuilder();

        recur(1, 0);

        System.out.print(sb);
    }//main

    static void recur(int start, int depth) {
        if (depth == M) {
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            visit[i] = true;
            answer[depth] = i;
            recur(i, depth + 1);
        }

    }

}//class
