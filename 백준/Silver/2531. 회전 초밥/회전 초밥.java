import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        String pack = Baekjoon.Silver.S1_2531.Main.class.getPackage().toString().split(" ")[1];
//        String realPack = String.join("/", pack.split("[.]")[1], pack.split("[.]")[2]);
//        BufferedReader br = new BufferedReader(new FileReader(realPack + "/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N + 1];
        int[] eaten = new int[d + 1];
        for (int i = 1; i <= N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int kind = 0;
        for (int i = 1; i <= k; i++) {
            if (eaten[sushi[i]]++ == 0) {
                kind++;
            }
        }

        int pastSushi = 1;
        int newSushi = k + 1;
        int max = kind;

        while (pastSushi <= N) {
//            System.out.println("start " + sushi[pastSushi] + " end " + sushi[newSushi]);

            if (eaten[sushi[pastSushi]]-- <= 1) { //방금 전이 중복 초밥이 아닐 경우
                kind--;
            }

            if (eaten[sushi[newSushi]]++ == 0) { //새로운 초밥일 경우에만
                kind++;
            }

            if (eaten[c]++ == 0) {
                kind++;
            }

//            System.out.println("kind " + kind + " max " + max);
            max = Math.max(kind, max);
            
            pastSushi++;
            newSushi++;
            
            if (newSushi > N) {
                newSushi %= N;
            }
        }
        System.out.println(max);
    }//main

}//class