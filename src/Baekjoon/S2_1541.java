package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("-");;
        int answer = 0;

        for (int i = 0; i < strArr.length; i++) {
            int sum = 0;
            if (strArr[i].contains("+")) {
                String[] plus = strArr[i].split("\\+");
                for (String p : plus) {
                    sum += Integer.parseInt(p);
                }
            } else {
                sum = Integer.parseInt(strArr[i]);
            }

            if (i == 0) answer += sum;
            else {
                answer -= sum;
            }
        }
        System.out.println(answer);

    }//main

}//class
