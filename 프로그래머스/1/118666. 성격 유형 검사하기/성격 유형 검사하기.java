import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> data = new HashMap<>();
        String answer = "";
        char[] types= {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for (char type : types) {
            data.put(type, 0);
        }

        for (int i = 0; i < choices.length; i++) {          
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            if (choices[i] > 4) {
                data.put(right, data.get(right) + choices[i] - 4);
            } else if (choices[i] < 4) {
                data.put(left, data.get(left) + 4 - choices[i]);
            }
        }
        
        for (int i = 0; i < 8; i += 2) {
            if (data.get(types[i]) < data.get(types[i+1])) {
                answer += String.valueOf(types[i+1]);
            } else {
                answer += String.valueOf(types[i]);
            }
        }
        return answer;
    }
}
    