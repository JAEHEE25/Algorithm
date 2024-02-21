import java.util.*;

class Solution {
    static boolean[] visit;
    static int[] idx;
    static int N;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        N = dungeons.length;
        visit = new boolean[N];
        idx = new int[N];
        backtracking(0, k, dungeons);
        return answer;
    }
    
    public void backtracking(int depth, int k, int[][] dungeons) {
        if (depth == N) {
            goDungeons(k, dungeons);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                idx[depth] = i;
                backtracking(depth + 1, k, dungeons);
                visit[i] = false;
            }
        }
    }
    
    public void goDungeons(int k, int[][] dungeons) {
        int cnt = 0;
        for (int i : idx) {
            int need = dungeons[i][0];
            int use = dungeons[i][1];
            
            if (k < need) break; //탐험 불가
            
            cnt++;
            k -= use;
        }
        answer = Math.max(cnt, answer);
    }
}

/*
> 최대 던전 수

백트래킹
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

백트래킹
depth가 d.len
순서 지정해주고

돌면서
*/