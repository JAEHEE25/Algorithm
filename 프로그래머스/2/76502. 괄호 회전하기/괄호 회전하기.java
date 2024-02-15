import java.util.*;
class Solution {
    static Map<Character, Character> map = new HashMap<>();
    static int answer = 0;
    
    public int solution(String s) {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        List<Character> sList = new LinkedList<>();
        for (char c : s.toCharArray()) {
            sList.add(c);
        }
        check(sList);
        
        List<Character> changed = new LinkedList<>();
        for (int i = 1; i < sList.size(); i++) {
            changed.add(sList.get(i));
        }
        changed.add(sList.get(0));
        
        while (!changed.equals(sList)) {
            check(changed);
            //회전
            changed.add(changed.get(0));
            changed.remove(0);
        }
        return answer;
    }
    
    public void check(List<Character> str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str) {
            if (map.keySet().contains(c)) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    break;
                }
                if (map.get(c) == stack.peek()) stack.pop(); //짝이면 pop
                else {
                    stack.push(c);
                    break;
                }
            } else {
                stack.push(c);
            }
        }     
        if (stack.isEmpty()) answer++;
    }
}
