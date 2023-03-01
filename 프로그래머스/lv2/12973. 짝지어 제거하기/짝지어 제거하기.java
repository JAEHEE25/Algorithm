import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        if (s.length() % 2 != 0) {
            return 0;
        }
        
        Map<Character, ArrayList<Integer>> map = new HashMap();
        
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            map.put(s.charAt(i), list);
        }
        
        for (int i = 0; i < s.length(); i++) {
            map.get(s.charAt(i)).add(i);
        }
        
        for (Map.Entry<Character, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> idxList = entry.getValue();

            if (idxList.size() % 2 != 0) {
                return 0;
            }
            
            int twoCnt = 0;
            for (int i = 0; i < idxList.size(); i+=2) {
                int minus = idxList.get(i+1) - idxList.get(i);
                if (minus % 2 == 0) {
                    twoCnt++;
                }
            }

            if (twoCnt % 2 != 0) {
                return 0;
            }
            
        }
        return answer;
    }//main
}//class