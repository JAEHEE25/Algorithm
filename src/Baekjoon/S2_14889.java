package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_14889 {
    static int N;
    static boolean[] visit;
    static int[][] info;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        visit = new boolean[N + 1];
        arr = new int[N];

        //2차원 배열 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0);

    }//main

    static void recur(int depth) {
        if (depth == N / 2) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;

            arr[depth] = i;
            visit[i] = true;
            recur(depth + 1);
            visit[i] = false;
        }

    }//recur

}//class

/*
1 2 3 4
1 3 2 4
1 4 2 3

1 2, 3 4
1 2
2 1
3 4
4 3

1 3, 2 4
1 3
3 1
2 4
4 2

1 4, 2 3
1 4
4 1
2 3
3 2
 */
