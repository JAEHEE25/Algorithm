import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            tree[i] = list;
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }//main

    static void DFS(int num) {
        visited[num] = true;
        for (int next : tree[num]) {
            if (visited[next]) {
                continue;
            }
            answer[next] = num;
            DFS(next);
        }

    }//DFS
}//class
