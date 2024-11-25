import java.util.*;
class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        int idx;
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][j+1], Math.max(dp[i-1][j+2], dp[i-1][j+3]));
                } else if (j == 1) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i-1][j+1], dp[i-1][j+2]));
                } else if (j == 2) {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][j-2], Math.max(dp[i-1][j-1], dp[i-1][j+1]));
                } else {
                    dp[i][j] = land[i][j] + Math.max(dp[i-1][j-3], Math.max(dp[i-1][j-2], dp[i-1][j-1]));
                }
            }
        }
        
        int answer = 0;
        for (int v : dp[land.length - 1]) {
            answer = Math.max(answer, v);
        }
        return answer;
    }
}