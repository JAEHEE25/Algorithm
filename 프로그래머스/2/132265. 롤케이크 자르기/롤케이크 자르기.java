import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] cheolsu = new int[topping.length];
        int[] brother = new int[topping.length];
        
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            cheolsu[i] = set.size();
        }
        set.clear();
        for (int i = topping.length - 1; i >= 0; i--) {
            set.add(topping[i]);
            brother[i] = set.size();
        }
        
        for (int i = 0; i < topping.length-1; i++) {
            if(cheolsu[i] == brother[i+1]) answer++;
        }
        return answer;
    }
}
