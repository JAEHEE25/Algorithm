import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = 1;

        while (true) {
            n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            solution(n);
        }

        System.out.print(sb);
    }//main

    static void solution(int start) {
        int end = 2 * start;
        int[] numArr = new int[end+1];

        for (int i = 2; i <= end; i++) {
            numArr[i] = i;
        }

        for (int i = 2; i <= end; i++) {

            if (numArr[i] != 0) {
                for (int j = i + i; j <= end; j += i) {
                    numArr[j] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = start + 1; i <= end; i++) {
            if (numArr[i] != 0) {
                cnt++;
            }
        }

        sb.append(cnt).append("\n");
    }//solution
}//class