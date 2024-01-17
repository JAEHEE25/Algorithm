import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] numbers;
    static boolean[] visit;
    static int[] opCount;
    static ArrayList<Character> operators;
    static char[] result;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        opCount = new int[4];
        for (int i = 0; i < 4; i++) {
            opCount[i] = Integer.parseInt(st.nextToken());
        }

        operators = new ArrayList<>();
        char[] op = {'+', '-', '*', '/'};

        //연산자 개수대로 char array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < opCount[i]; j++) {
                operators.add(op[i]);
            }
        }

        result = new char[N - 1];
        visit = new boolean[operators.size()];
        backtracking(0);

        System.out.println(max);
        System.out.println(min);
    }//main

    static void backtracking(int depth) {
        if (depth == N - 1) {
            calculate(); //답 계산
            return;
        }
        for (int i = 0; i < operators.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = operators.get(i);
                backtracking(depth + 1);
                visit[i] = false;
            }
        }
    }

    static void calculate() {
        int answer = numbers[0];
        int idx = 1;
        for (char r : result) {
            if (r == '+') {
                answer += numbers[idx];
            } else if (r == '-') {
                answer -= numbers[idx];
            } else if (r == '*') {
                answer *= numbers[idx];
            } else { //나누기일 때
                if (answer < 0) { //음수일 경우에는
                    answer = (Math.abs(answer) / numbers[idx]) * (-1);
                } else {
                    answer /= numbers[idx];
                }
            }
            idx++;
        }

        //최소, 최대 구하기
        max = Math.max(answer, max);
        min = Math.min(answer, min);
    }
}//class