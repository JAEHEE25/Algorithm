class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int same = 0;
        int other = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == first) same++;
            else other++;
            if (same == other) {
                answer++;
                same = 0;
                other = 0;
                
                if (i+1 == s.length()) break;
                first = s.charAt(i+1);    
            } else {
                if (i+1 == s.length()) answer++;
            }
        }
        return answer;
    }
}