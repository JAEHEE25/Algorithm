import java.util.*;

class Solution {
    static ArrayList<Integer>[] close;
    static boolean[] visit;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        close = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) { //그래프 초기화
            close[i] = new ArrayList<>();
        }      

        for (int i = 0; i < wires.length; i++) { //인접 추가
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            close[v1].add(v2);
            close[v2].add(v1);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];    
            
            close[v1].remove(Integer.valueOf(v2)); //삭제
            close[v2].remove(Integer.valueOf(v1));
            
            visit = new boolean[n + 1];
            int count = DFS(1);
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            close[v1].add(v2); //다시 추가
            close[v2].add(v1);
        }
        return answer;
    }
    
    public int DFS(int num) {
        visit[num] = true;
        int count = 1;
        
        for (int next : close[num]) {
            if (!visit[next]) count += DFS(next);
        }
        
        return count;
    }
}