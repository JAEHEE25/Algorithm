import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] close;
    static int[] answer;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        close = new ArrayList[N + 1];
        answer = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            close[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            close[x].add(y);
            close[y].add(x);
        }

        recur(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }//main

    static void recur(int num) {
        visit[num] = true;

        for (int next : close[num]) {
            if (visit[next]) {
                answer[num] = next;
                continue;
            }
            recur(next);
        }
    }
}//class