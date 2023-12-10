package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_15663 {
    static int N;
    static int M;
    static boolean[] visit;
    static int[] arr;
    static int[] answer;
    static ArrayList<int[]> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = new int[M];
        Arrays.sort(arr);

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }

        int before = 0;
        for (int i = 0; i < N; i++) {
            if (!visit[i] && before != arr[i]) {
                visit[i] = true;
                answer[cnt] = arr[i];
                before = arr[i];
                dfs(cnt + 1);
                visit[i] = false;
            }
        }
    }
}//class