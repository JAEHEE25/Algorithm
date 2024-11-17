import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] close;
    static boolean[] visit;
    static int X;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        close = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            close[i] = new ArrayList<>();
        }

        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            close[i].add(p);
            if (p != -1) {
                close[p].add(i);
            } else {
                root = i;
            }
        }

        X = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            Collections.sort(close[i], Collections.reverseOrder());
        }
        if (root == X) {
            answer = 0;
        } else {
            DFS(root);
        }
        System.out.println(answer);
    }//main

    static void DFS(int num) {
        visit[num] = true;
        int size = close[num].size();

        for (int next : close[num]) {
            if (next == -1) {
                if (size == 1) answer++;
                continue;
            }
            if (next == X) {
                size--;
                continue;
            }
            if (visit[next]) {
                if (size == 1) {
                    answer++;
                }
                continue;
            }
            DFS(next);
        }
    }
}//class