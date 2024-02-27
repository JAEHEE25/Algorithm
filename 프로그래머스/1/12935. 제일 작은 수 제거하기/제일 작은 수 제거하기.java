import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int min = Integer.MAX_VALUE;
        for (int a : arr) {
            list.add(a);
            min = Math.min(min, a);
        }    
        list.remove((Object) min);
        
        if (list.size() == 0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}