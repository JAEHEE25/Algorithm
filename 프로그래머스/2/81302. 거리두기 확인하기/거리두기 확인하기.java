import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static char[][] seat;
    static int[] answer;
    public int[] solution(String[][] places) {
        visit = new boolean[5][5];
        seat = new char[5][5];
        answer = new int[5];
        Arrays.fill(answer, 1);
        
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < 5; j++) {
                seat[j] = places[i][j].toCharArray();
            }
            
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (seat[j][k] == 'P') {
                        visit[j][k] = true;
                        backtracking(j, k, 0, i);
                        visit[j][k] = false;
                    }
                }
            }
        }
        return answer;
    }
    
    static void backtracking(int x, int y, int count, int i) {
        if (count > 2) {
            return;
        } else {
            if (count != 0 && seat[x][y] == 'P') { //거리 2 이하 & 응시자
                answer[i] = 0;
                return;
            }
        }
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visit[nx][ny] || seat[nx][ny] == 'X') continue;
            
            visit[nx][ny] = true;
            backtracking(nx, ny, count + 1, i);
            visit[nx][ny] = false;
        }
    }
}