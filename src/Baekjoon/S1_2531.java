package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //벨트의 접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        //belt 입력
        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int kind = 0;
        //처음 k개의 가짓수
        for (int i = 0; i < k; i++) {
            map.putIfAbsent(belt[i], 0);
            map.put(belt[i], map.get(belt[i]) + 1);
        }

        kind = countKind(map, c);

        System.out.println(map + " 첫 " + kind);

        //돌면서 가짓수
        int start = 0;
        int end = k;

        while (start < N) {
            if (end >= N) end = end % N;
            System.out.println(belt[start] + " " + belt[end]);
            map.putIfAbsent(belt[start], 0);
            map.put(belt[start], map.get(belt[start]) - 1);

            map.putIfAbsent(belt[end], 0);
            map.put(belt[end], map.get(belt[end]) + 1);

            if (map.get(belt[start]) <= 0) {
                map.remove(belt[start]);
            }

            System.out.println("삭제 후 " + map);

            kind = Math.max(kind, countKind(map, c)); //더 큰 값으로 저장
            System.out.println("kind " + kind);

            start++;
            end++;
        }

        System.out.println(kind);
    }//main

    static int countKind(Map<Integer, Integer> map, int c) {
        int count = map.keySet().size();
        if (!map.containsKey(c)) count += 1;
        System.out.println("count " + count);
        return count;
    }


}//class


