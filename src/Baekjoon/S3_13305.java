package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == N-1) {
                distance[i] = 0;
                continue;
            }
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];
        for (int i = 0; i < N; i++) {
            if (cost[i] <= minCost) {
                sum += cost[i] * distance[i];
                minCost = Math.min(minCost, cost[i]);
            } else {
                sum += minCost * distance[i];
            }
        }

        System.out.println(sum);
    }//main

}//class
