import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0 ; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                sb.append(String.valueOf(i).repeat((food[i] - 1) / 2));
            } else {
                sb.append(String.valueOf(i).repeat(food[i] / 2));
            }
        }
        String answer = String.valueOf(sb);
        String reverse = String.valueOf(sb.reverse());
        return answer + "0" + reverse;
    }
}