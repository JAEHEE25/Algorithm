import java.util.*;
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int N;
    static int M;
    static int answer = 0;
    static boolean isAnswer = false;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        BFS(0,0, maps);

        if (!isAnswer) answer = -1;
        return answer;
    }
    
    public void BFS(int x, int y, int[][] maps) {
        Queue<Place> queue = new LinkedList<>();
        queue.add(new Place(x, y, 1));
        
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            
            if (poll.x == N-1 && poll.y == M-1) {
                isAnswer = true;
                answer = poll.cnt;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }
                
                queue.add(new Place(nx, ny, poll.cnt+1));
                visit[nx][ny] = true;
            }
        }
    
    }
}

class Place {
    int x;
    int y;
    int cnt;
    
    Place(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}