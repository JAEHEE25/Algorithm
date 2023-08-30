package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1753 {

  static int V;
  static int[] dist;
  static ArrayList<node>[] nodeList;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int start = Integer.parseInt(st.nextToken());

    dist = new int[V+1];  //거리 테이블
    Arrays.fill(dist, Integer.MAX_VALUE);  //무한대로 채움
    nodeList = new ArrayList[V+1];

    for (int i = 1; i < V+1; i++) {  //초기화
      ArrayList<node> list = new ArrayList<>();
      nodeList[i] = list;
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      nodeList[u].add(new node(v, w));
    }

    dijkstra(start);

    for (int i = 1; i <= V; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
        continue;
      }
      System.out.println(dist[i]);
    }


  }//main

  static void dijkstra(int start) {
    PriorityQueue<node> queue = new PriorityQueue<>();
    queue.add(new node(start, 0));
    dist[start] = 0;

    while (!queue.isEmpty()) {
      node cur = queue.poll();  //현재 이 노드에 왔당
      //그리고 어케할까?
      for (node next : nodeList[cur.v]) {
        if (dist[cur.v] + next.w < dist[next.v]) {
          dist[next.v] = dist[cur.v] + next.w;
          queue.add(new node(next.v, dist[next.v]));
        }
      }
    }
  }//dijkstra
}//class

class node implements Comparable<node> {
  int v, w;
  //목적지, 가중치

  public node(int v, int w) {
    this.v = v;
    this.w = w;
  }

  @Override
  public int compareTo(node n) {
    return this.w - n.w;  //가중치 기준 오름차순
  }
}
