package test;

import java.io.IOException;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {
            int N = sc.nextInt();  //지연장치 개수
            int D = sc.nextInt();
            int[][] latency = new int[N][2];

            for (int i = 0; i < N; i++) {
                latency[i][0] = sc.nextInt();
                latency[i][1] = sc.nextInt();
            }
            int i = 0;
            int j = D;

            while (i != j) {
                System.out.println("i " + i + " j " + j);
                if (check(i, latency, N) != 0) {
                    j -= check(i, latency, N) + 1;
                    i += 1;
                } else if (check(j, latency, N) != 0) {
                    i += check(j, latency, N) + 1;
                    j -= 1;
                } else {
                    i++;
                    j--;
                }
            }
            System.out.println("#" + (test_case+1) + " " + i);
        }//test
    }//main

    static int check(int x, int[][] latency, int N) {
        for (int i = 0; i < N; i++) {
            if (x == latency[i][0]) {
                return latency[i][1];
            }
        }
        return 0;
    }//check
}//class