import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> disMap = new HashMap<>();
        
        //wantMap 만들기
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        //처음 10일 확인
        for (int i = 0; i < 10; i++) {
            if (wantMap.keySet().contains(discount[i])) {
                disMap.put(discount[i], disMap.getOrDefault(discount[i], 0) + 1);
            }
        }
        check(wantMap, disMap);
        
        //다음부터 확인
        int start = 0;
        int end = 10;
        while (end < discount.length) {
            String remove = discount[start];
            String add = discount[end];
            if (wantMap.keySet().contains(add)) {
                disMap.put(add, disMap.getOrDefault(add, 0) + 1);
            }
            if (wantMap.keySet().contains(remove)) {
                disMap.put(remove, disMap.getOrDefault(remove, 0) - 1);
            }
            check(wantMap, disMap);
            
            start++;
            end++;
        }
        
        return answer;
    }
    
    public void check(Map<String, Integer> wantMap, Map<String, Integer> disMap) {
        boolean isAnswer = true;
        for (String item : wantMap.keySet()) {
            if (wantMap.get(item) > disMap.getOrDefault(item, 0)) {
                isAnswer = false;
                break;
            }
        }
        if (isAnswer) answer++;
    }
}