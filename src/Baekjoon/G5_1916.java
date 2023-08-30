package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G5_1916 {
    static ArrayList<City>[] graph;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        cost = new int[N + 1];

        //무한대로 초기화
        Arrays.fill(cost, Integer.MAX_VALUE);

        //그래프 초기화
        for (int i = 1; i <= N; i++) {
            ArrayList<City> list = new ArrayList<>();
            graph[i] = list;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new City(e, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(cost[end]);
    }//main

    static void dijkstra(int start) {
        PriorityQueue<City> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        queue.add(new City(start, 0));
        cost[start] = 0;

        while (!queue.isEmpty()) {
            City cur = queue.poll();

            if (cur.cost > cost[cur.num]) continue;

            for (City next : graph[cur.num]) {
                if (next.cost + cost[cur.num] < cost[next.num]) {
                    cost[next.num] = next.cost + cost[cur.num];
                    queue.add(new City(next.num, cost[next.num]));
                }
            }
        }
    }//dijkstra

}//class

class City {

    public int num;
    public int cost;

    public City(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}
