package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int answer = 0;

        Arrays.sort(arr);
        //1 2 3 5 7 9 10 11 12

        int start = 0;
        int end = n-1;
        int sum;

        while (start < end) {
            sum = arr[start] + arr[end];

            if (sum == x) {
                System.out.println(arr[start] + " " + arr[end]);
                answer++;
                start++;
                end--;
            } else if (sum < x) { //합이 더 커져야하므로 start를 더하기
                start++;
            } else { //합이 더 작아져야하므로 end를 빼기
                end--;
            }
        }

        System.out.println(answer);
    }//main

}//class
