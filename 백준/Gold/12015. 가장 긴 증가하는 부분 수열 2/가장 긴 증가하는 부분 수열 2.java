import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < N; i++) {
            int now = arr[i];
            int last = list.get(list.size() - 1);

            if (now > last) { //마지막 원소보다 크면
                list.add(now);
            } else { //마지막 원소보다 작으면
                binarySearch(now);
            }
        }

        System.out.println(list.size());
    }//main

    static void binarySearch(int now) { //now의 인덱스 찾아서 원소 변경
        int start = 0;
        int end = list.size() - 1;
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (now <= list.get(mid)) { //now가 mid보다 작으면 end 줄이기
                end = mid;
            } else { //now가 mid보다 크면 start 늘리기
                start = mid + 1;
            }
        }

        list.set(end, now);

    }//binarySearch

}//class

/*
5
10 20 30 5 6
 */
