package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] applicants = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken());
                applicants[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (o1, o2) -> {
                return o1[0] - o2[0];
            });

//            System.out.println(Arrays.deepToString(applicants));
            int min = applicants[0][1];
            int cnt = 0;

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] > min) {
                    cnt++;
                }
                min = Math.min(min, applicants[i][1]);
            }

            System.out.println(N - cnt);
        } //testcase

    }//main
}//class