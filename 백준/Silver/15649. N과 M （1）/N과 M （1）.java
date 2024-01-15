import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        result = new int[M];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        backtracking(0);
        System.out.println(sb);
    }//main

    static void backtracking(int depth) {
        if (depth == M) {
            for (int num : result) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { //방문하지 않았다면
                visited[i] = true; //방문 처리
                result[depth] = i; //결과 저장
                backtracking(depth + 1); //다음 depth 진행
                visited[i] = false; //방문 false
            }
        }
    }//backtracking
}//class