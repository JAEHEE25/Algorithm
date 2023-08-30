import java.util.Scanner;

public class Main {

    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] dp = new long[N + 1][10];

        //길이가 1일 경우, 모두 1로 저장
        for (int i = 1; i < 10; i++) { //1 ~ 9
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) { //2 ~ N
            for (int j = 0; j < 10; j++) { //0 ~ 9로 끝남
                if (j == 0) dp[i][j] = dp[i-1][1] % mod; //0일 경우
                else if (j == 9) dp[i][j] = dp[i-1][8] % mod; //9일 경우
                else { //둘 다 아닐 경우
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) { //0 ~ 9
            answer += dp[N][i];
        }

        System.out.println(answer % mod);
    }//main
}//class
