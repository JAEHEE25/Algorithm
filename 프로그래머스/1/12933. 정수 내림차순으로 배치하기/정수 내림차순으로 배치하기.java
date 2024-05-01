import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
    
        StringBuilder sb = new StringBuilder(String.valueOf(arr));
        answer = Long.parseLong(sb.reverse().toString());
        return answer;
    }
}