import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int l = 0;
        for (int h = people.length - 1; h >= l; h--) {
            if (people[l] + people[h] <= limit) { //둘이 탈 수 있으면
                l++;
            }
            answer++;
        }
        return answer;
    }
}