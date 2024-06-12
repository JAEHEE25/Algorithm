import java.io.*;
import java.util.*;

public class Main {
    static int[] stairs;
    static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        point = new int[N + 1]; //point[계단] = 계단까지의 최대 점수
        Arrays.fill(point, -1);

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        point[0] = 0;
        point[1] = stairs[1];
        
        if (N >= 2) {
            point[2] = stairs[1] + stairs[2];
        }
        
        System.out.println(recur(N));
    }//main

    public static int recur(int N) {
        if (point[N] == -1) {
            point[N] = Math.max(recur(N - 3) + stairs[N - 1], recur(N - 2)) + stairs[N];
        }
        return point[N];
    }
}//class