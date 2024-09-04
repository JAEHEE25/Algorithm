import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        Arrays.fill(wheel, '?');

        int t = 0; //전체 횟수
        int idx = 0; //인덱스
        while (t < K) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            char letter = st.nextToken().charAt(0);

            if (t == 0) {
                wheel[0] = letter;
            } else {
                int newIdx = (idx + count) % N;
                if (wheel[newIdx] != '?' && wheel[newIdx] != letter) {
                    System.out.println('!');
                    return;
                }
                wheel[newIdx] = letter;
                idx = newIdx;
            }
            t++;
        }

        //마지막 letter 부터 돌면서 출력
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            char c = wheel[idx];
            if (c != '?' && sb.indexOf(String.valueOf(c)) != -1) {
                System.out.println('!');
                return;
            }
            sb.append(c);
            idx--;
            if (idx < 0) idx = N - 1;
            i++;
        }
        System.out.println(sb);
    }//main
}//class
