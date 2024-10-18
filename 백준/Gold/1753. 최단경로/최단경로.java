import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int K;
    static ArrayList<Node>[] close;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        close = new ArrayList[V + 1];
        distance = new int[V + 1];
        visit = new boolean[V + 1];

        // 인접 리스트 초기화
        for (int i = 1; i <= V; i++) {
            close[i] = new ArrayList<>();
        }

        // 인접 리스트 추가
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            close[u].add(new Node(v, w));
        }

        // 최단 거리 배열 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);

        // 다익스트라
        dijkstra();

        // 정답 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (visit[i]) answer.append(distance[i]);
            else answer.append("INF");
            answer.append("\n");
        }
        System.out.println(answer);
    }//main

    static void dijkstra() {
        // 시작 노드 설정
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        distance[K] = 0;

        // 다익스트라
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visit[current.v]) {
                continue;
            } else {
                visit[current.v] = true;
            }

            for (Node next : close[current.v]) {
                if (distance[next.v] > distance[current.v] + next.w) {
                    distance[next.v] = distance[current.v] + next.w;
                    queue.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}//class

class Node implements Comparable<Node> {
    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node n) {
        if (this.w > n.w) return 1;
        return -1;
    }
}