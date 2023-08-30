import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = 0; //쇠막대기 개수

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (letter == '(') { //여는 괄호일 경우 스택에 push
                stack.push(letter);
            } else { //닫는 괄호일 경우
                stack.pop();
                if (input.charAt(i - 1) == '(') { //바로 전 문자가 여는 괄호일 경우
                    answer += stack.size();
                } else { //쇠막대기가 끝남
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }//main

}//class
