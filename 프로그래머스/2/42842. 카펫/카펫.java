import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        int N = brown + yellow;
        
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                if (list.contains(N / i)) {
                    break;
                }
                list.add(i);
                list.add(N / i);
            }
        }
        
        Collections.sort(list);
        
        int j = list.size() - 1;
        for (int i = 0; i < list.size() / 2; i++) {
            if ((list.get(i) - 2) * (list.get(j) - 2) == yellow) {
                answer[0] = list.get(j);
                answer[1] = list.get(i);
                break;
            }
            j--;
        }
        return answer;
           
    }
}
