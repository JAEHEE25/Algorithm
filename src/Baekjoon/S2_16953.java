package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S2_16953 {
    static int A;
    static int B;
    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        answer = -1;

        BFS();
        System.out.println(answer);
    }//main

    static void BFS() {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(A, 1));

        while (!queue.isEmpty()) {
            Number poll = queue.poll();
            long multipleTwo = poll.num * 2;
            long plusOne = Long.parseLong(poll.num + "1");

//            System.out.println(poll.num + " " + multipleTwo + " " + plusOne);

            if (multipleTwo == B || plusOne == B) {
                answer = poll.cnt + 1;
                break;
            }

            if (multipleTwo > 10e9 && plusOne > 10e9) {
                continue;
            }

            queue.add(new Number(multipleTwo, poll.cnt + 1));
            queue.add(new Number(plusOne, poll.cnt + 1));
        }
    }

    static class Number {
        long num;
        int cnt;

        Number(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}//class

//162 81 8 4 2
//42 21 2