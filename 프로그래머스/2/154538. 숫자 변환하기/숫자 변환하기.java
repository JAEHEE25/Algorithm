import java.util.*;
class Solution { 
    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (dp[i] != max) {
                int three = i * 3;
                int two = i * 2;
                int plus = i + n;
            
                if (three <= y) dp[three] = Math.min(dp[i] + 1, dp[three]); 
                if (two <= y) dp[two] = Math.min(dp[i] + 1, dp[two]); 
                if (plus <= y) dp[plus] = Math.min(dp[i] + 1, dp[plus]); 
            }
        }
        
        if (dp[y] == max) return -1;
        return dp[y];
    }
}