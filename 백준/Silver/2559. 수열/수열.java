import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        String pack = Baekjoon.Silver.S3_2559.Main.class.getPackage().toString().split(" ")[1];
        String realPack = String.join("/", pack.split("[.]")[1], pack.split("[.]")[2]);
        BufferedReader br = new BufferedReader(new FileReader(realPack + "/input.txt"));
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] temperature = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < K; i++) {
            max += temperature[i];
        }

        int start = 0;
        int end = K;
        int sum = max;

        while (end < N) {
            //System.out.println(start + " " + end);
            sum -= temperature[start];
            sum += temperature[end];

//            System.out.println("sum " + sum + " max " + max);
            max = Math.max(max, sum);

            start++;
            end++;
        }

        System.out.println(max);
    }//main
}//class
