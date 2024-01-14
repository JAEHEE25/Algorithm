import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> info = new HashMap<>();
        
        for (int stage = 1; stage <= N; stage++) {
            int stopped = 0;
            int tried = 0;
            for (int user : stages) {
                if (user >= stage) {
                    tried++;
                }
                
                if (user == stage) {
                    stopped++;
                }  
            }
            info.put(stage, (double) stopped/tried);
        }
        
        List<Integer> keyList = new ArrayList<>(info.keySet());
        
        for (int i = 0; i < N; i++) {
            answer[i] = keyList.get(i);
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (info.get(answer[j]) > info.get(answer[j-1])) {
                    int tmp1 = answer[j-1];
                    answer[j-1] = answer[j];
                    answer[j] = tmp1;
                } else if (info.get(answer[j]) == info.get(answer[j-1])) {
                    if (answer[j] < answer[j-1]) {
                        int tmp1 = answer[j-1];
                        answer[j-1] = answer[j];
                        answer[j] = tmp1;
                    }
                }
            }
        }

        return answer;
    }
}