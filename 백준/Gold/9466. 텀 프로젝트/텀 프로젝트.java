import java.io.*;
import java.util.*;

public class Main {
    static int[] selected;
    static boolean[] visit;
    static boolean[] finish;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            selected = new int[N + 1];
            visit = new boolean[N + 1]; //방문
            finish = new boolean[N + 1]; //탐색 종료

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                selected[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) dfs(i); //방문하지 않은 노드에 dfs
            }
            answer.append(N - cnt).append("\n");
        }
        System.out.println(answer);
    } //main

    public static void dfs(int num) {
        visit[num] = true;
        int next = selected[num];

        if (visit[next]) { //방문함
            if (!finish[next]) { //&&탐색 종료되지 않음 -> 사이클
                for (int i = next; i != num; i = selected[i]) { //정점 개수 구하기 (다음 정점이 num일 때까지 순회)
                    cnt++;
                }
                cnt++; //자기 자신
            }
        } else {
            dfs(next);
        }
        finish[num] = true;
    }
}