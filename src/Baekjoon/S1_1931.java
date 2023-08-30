package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] meeting = new long[N][2];

        for (int i = 0; i < N; i++) { //2차원 배열 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            meeting[i][0] = x;
            meeting[i][1] = y;
        }

        Arrays.sort(meeting, (o1, o2) -> {
            return (int) (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        });

        int answer = 0;
        long start = meeting[0][0]; //시작 시간

        for (int i = 0; i < N; i++) {
            long nowStart = meeting[i][0];
            long nowEnd = meeting[i][1];

            if (nowStart >= start) {
                start = nowEnd;
                answer++;
            }
        }
        System.out.println(answer);
    }//main

}//class