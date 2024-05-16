import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        List<String> list = new ArrayList<>();
        int[] status = new int[10];
        for (int i = 0; i < 10; i++) {
            status[i] = 0;
        }
        
        for (int i = 0; i < X.length(); i++) {
            int idx = X.charAt(i) - 48;
            status[idx] += 1;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int idx = Y.charAt(i) - 48;
            if (status[idx] != 0) { //X에 있는 숫자
                list.add(String.valueOf(Y.charAt(i)));
                status[idx]--;
            }
        }
        
        String answer = "";
        if (list.isEmpty()) answer = "-1";
        else {
            StringBuilder sb = new StringBuilder();
            Collections.sort(list, Collections.reverseOrder());
            for (String str : list) {
                sb.append(str);
            }
            answer = sb.toString();
            if (answer.startsWith("0")) answer = "0";
        }
    
        return answer;
    }
}
