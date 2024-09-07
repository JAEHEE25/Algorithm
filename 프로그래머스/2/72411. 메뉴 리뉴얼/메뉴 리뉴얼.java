import java.util.*;

class Solution {
    static StringBuilder sb;
    static boolean[] visit;
    static List<String> list;
    
    public String[] solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        
        for (int max : course) {
            for (String order : orders) {
                visit = new boolean[26];
                sb = new StringBuilder();
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                combination(0, max, 0, orderArr);
            }
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String order : list) {
            map.put(order, map.getOrDefault(order, 0) + 1);
        }
        
        int[] maxCounts = new int[course.length];
        for (int i = 0; i < course.length; i++) {
            int max = 0;
            
            for (String order : map.keySet()) {
                if (order.length() == course[i] && map.get(order) > 1) {
                    max = Math.max(max, map.get(order));
                }
            }
            maxCounts[i] = max;
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < maxCounts.length; i++) {
            for (String order : map.keySet()) {
                if (order.length() == course[i] && map.get(order) == maxCounts[i]) {
                    result.add(order);
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }
    
    public void combination(int count, int max, int start, char[] orderArr) {
        if (count == max) {
            list.add(sb.toString());
            return;
        }
        for (int i = start; i < orderArr.length; i++) {
            int alphaIdx = orderArr[i] - 65;
            if (!visit[alphaIdx]) {
                sb.append(orderArr[i]);
                visit[alphaIdx] = true;
                
                combination(count + 1, max, i, orderArr);
                
                visit[alphaIdx] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        
    }
}