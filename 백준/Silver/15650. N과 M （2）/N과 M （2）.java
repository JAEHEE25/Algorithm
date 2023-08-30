import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static boolean[] visit;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visit = new boolean[N+1];
        answer = new int[M];
        sb = new StringBuilder();

        if (N == M) {
            for (int i = 1; i <= N; i++) {
                sb.append(i).append(" ");
            }
        } else {
            recur(0, 1);
        }

        System.out.print(sb);
    }//main

    static void recur(int depth, int start) {

        if (depth == M) {
            for (int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if (visit[i]) {
                continue;
            }
            answer[depth] = i;
            visit[i] = true;
            recur(depth + 1, i + 1);
            visit[i] = false;


        }

    }//recur

}//class