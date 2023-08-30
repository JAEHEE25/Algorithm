import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int maxSum = 2000000000;
        int[] answer = new int[2];

        while (left < right) {
            int result = arr[left] + arr[right];
            if (Math.abs(result) < maxSum) { //sum보다 작으면
                maxSum = Math.abs(result); //갱신
                answer[0] = arr[left];
                answer[1] = arr[right];
            }

            if (result > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }//main
}//class
