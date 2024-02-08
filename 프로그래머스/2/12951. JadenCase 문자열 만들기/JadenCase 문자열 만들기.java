import java.util.*;
class Solution {
    public String solution(String s) {
        char[] result = s.toCharArray();
        
        result[0] = String.valueOf(result[0]).toUpperCase().charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char prev = result[i-1];
            char now = result[i];
            if (prev == ' ') {
                result[i] = String.valueOf(result[i]).toUpperCase().charAt(0);
            } else {
                result[i] = String.valueOf(result[i]).toLowerCase().charAt(0);
            }
        }
        return String.valueOf(result);
    }
}