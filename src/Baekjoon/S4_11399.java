package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(time);

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += time[i];
            for (int j = 0; j < i; j++) {
                sum += time[j];
            }
        }

        System.out.println(sum);
    }//main
}//class
