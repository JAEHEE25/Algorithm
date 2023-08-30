import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] soldiers = new int[N];
        int[] dp = new int[N];
        int answer = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        for (int i = N - 2; i >= 0; i--) { //0 ~ N-2
            for (int j = N - 1; j > i; j--) { //N-1 ~ i-1

                if (soldiers[j] < soldiers[i]) { //증가하면
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(N - answer);

    }//main
}//class
