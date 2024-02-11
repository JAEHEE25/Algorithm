import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!map.keySet().contains(letter)) {
                map.put(letter, i);
                answer[i] = -1;
                continue;
            }
            answer[i] = i - map.get(letter);
            map.put(letter, i);
        }
        return answer;
    }
}