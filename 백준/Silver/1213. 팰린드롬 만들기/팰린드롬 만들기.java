import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        char[] cArr = input.toCharArray();
        Arrays.sort(cArr);
        String str = String.valueOf(cArr);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if (map.containsKey(c)) { //이미 개수를 센 알파벳이라면 continue
                continue;
            }
            int cnt = str.length() - str.replace(c, "").length(); //전체 문자열 길이 - c를 제외한 문자열 길이 = c의 개수
            map.put(c, cnt);
        }

        boolean isOdd = false;
        int oddCnt = 0;
        String mid = "";

        for (String key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                oddCnt++;
                if (oddCnt != 1) { //개수가 홀수인 알파벳이 한 개가 아니라면
                    isOdd = true;
                    break;
                }
                mid = String.valueOf(key.charAt(0));
            }
        }

        if (isOdd) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            String front = "";

            for (int i = 0; i < cArr.length; i++) {
                String letter = String.valueOf(cArr[i]);
                if (!front.contains(letter)) { //문자열에 이미 있는 알파벳이라면 패스
                    front += letter.repeat(map.get(letter) / 2);
                }
            }

            System.out.println(front + mid + reverse(front));
        }

    }//main

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }
}//class
