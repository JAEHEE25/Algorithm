import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        List<String>[] keys = new ArrayList[keymap.length];
        for (int i = 0; i < keymap.length; i++) {
            List<String> list = new ArrayList<>(Arrays.asList(keymap[i].split("")));
            keys[i] = list;
        }
        
        for (int i = 0; i < targets.length; i++) {
            String[] target = targets[i].split("");
            for (int j = 0; j < target.length; j++) {
                int cnt = getMinCnt(target[j], keys);
                if (cnt == 101) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += (cnt + 1);           
            }
        }
        return answer;
    }
    
    public int getMinCnt(String letter, List<String>[] keys) {
        int min = 101;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].contains(letter)) {
                min = Math.min(min, keys[i].indexOf(letter));
            }
        }
        return min;
    }
}
