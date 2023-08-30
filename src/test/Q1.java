package test;

import java.io.*;
import java.util.*;

class Q1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] people = new int[N];

            for (int i = 0; i < N; i++) {  //초기화
                people[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                int idx = i + Math.abs(people[i]);
                System.out.println("idx " + idx);
                System.out.println(list);
                if (idx < 0 || idx >= N || check(i, idx, list)) continue;

                int value = people[idx];
                System.out.println("value " + value);
                if (people[i] >= 0 && people[i] + value == 0) {
                    answer++;
                    list.add(idx);
                }
            }
            System.out.println("#" + (test_case+1) + " " + answer + "\n");
        }//test
    }//main

    static boolean check(int i, int idx, ArrayList<Integer> list) {
        for (int num : list) {
            if (num == i || num == idx) {
                return true;
            }
        }
        return false;
    }//check

}//class

