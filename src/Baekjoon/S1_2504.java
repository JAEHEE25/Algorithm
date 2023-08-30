package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S1_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int value = 1;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (now == '(') {
                stack.push(now);
                value *= 2;
            } else if (now == '[') {
                stack.push(now);
                value *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if (str.charAt(i-1) == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (str.charAt(i-1) == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }

    }//main

}//class


