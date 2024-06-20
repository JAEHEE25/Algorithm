import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        while (!list.isEmpty()) {
            idx += (K-1);
            idx %= list.size();
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");

        System.out.println(sb);
    }//main
}//class