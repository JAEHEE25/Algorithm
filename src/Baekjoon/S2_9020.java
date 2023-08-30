package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_9020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[10001];
        boolean[] visited = new boolean[10001];

        //소수만 남기기
        for (int i = 2; i <= 10000; i++) {
            for (int j = i + i; j <= 10000; j += i) { //배수 제거
                isNotPrime[j] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int min = num; //두 수의 차
            String result = "";

            for (int j = 2; j <= num / 2; j++) {
                System.out.println("j " + j);
                System.out.println("j는 소수가 아니다 " + isNotPrime[j]);
                if (isNotPrime[j] || (num - j) == 1) {
                    System.out.println(j + "는 방문 안해용");
                    continue;
                }
                if (!isNotPrime[num - j]) {
                    System.out.println(num - j);
                    System.out.println("num - j도 소수다 " + isNotPrime[num-j]);

                    if ((num - j) - j < min) {
                        result = j + " " + (num - j);
                        min = (num - j) - j; //두 수의 차가 최소
                        System.out.println("result " + result);
                        System.out.println("최소 차이 " + min);
                    }
                }
            }
            sb.append(result).append("\n");
            visited = new boolean[10001];
        }

        System.out.print(sb);
    }//main

}//class

//2 3 5 7
