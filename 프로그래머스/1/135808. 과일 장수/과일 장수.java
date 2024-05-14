import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score); //정렬
        
        int startIdx = score.length % m; //버리는 사과 제외
        for (int i = startIdx; i < score.length; i += m) {
            answer += score[i] * m * 1; //사과 가격 계산
        }
        return answer;
    }
}