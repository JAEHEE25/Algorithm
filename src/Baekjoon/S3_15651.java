package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class S3_15651 {

    static int N;
    static int M;
    static boolean[] visit;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[N+1];
        answer = new int[M];

        recur(0);
        System.out.print(sb);
    }//main

    static void recur(int depth) {
        if (depth == M) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            answer[depth] = i;
            recur(depth + 1);
        }
    }//recur
}//class
