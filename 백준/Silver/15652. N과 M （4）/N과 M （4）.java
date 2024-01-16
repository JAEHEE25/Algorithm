import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        result = new int[M];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        backtracking(1, 0);

        System.out.println(sb);
    }//main

    static void backtracking(int start, int depth) {
        if (depth == M) {
            for (int r : result) {
                sb.append(r).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            backtracking(i, depth + 1);
        }
    }
}//class