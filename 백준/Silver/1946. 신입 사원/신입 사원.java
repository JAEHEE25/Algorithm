import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(reader.readLine());

        for(int i=0;i<cases;i++){
            int n=Integer.parseInt(reader.readLine());
            int[] scoreArr = new int[n+1];
            for (int j = 0; j < n; j++) {
                String[] strArr = reader.readLine().split(" ");
                int doc=Integer.parseInt(strArr[0]);
                int itv=Integer.parseInt(strArr[1]);
                scoreArr[doc]=itv;
            }
            int answer = 1;
            int standardItv = scoreArr[1];
            for(int k=2; k<=n;k++){
                if(scoreArr[k]<standardItv){
                    answer++;
                    standardItv=scoreArr[k];
                }
            }
            System.out.println(answer);
        }
    }
}