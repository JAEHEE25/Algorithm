import java.util.*;
class Solution {
    static final int NOT_VISIT = -1;
    static final int VISIT = 0;
    static int[][] dist;
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], NOT_VISIT);
        }
        
        BFS(maps);
        return dist[n-1][m-1] == -1 ? -1 : dist[n-1][m-1] + 1;
    }
    
    void BFS(int[][] maps) {
        Queue<Characters> queue = new LinkedList<>();
        queue.add(new Characters(0, 0));
        dist[0][0] = VISIT;
        
        while (!queue.isEmpty()) {
            Characters poll = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0 || dist[nx][ny] != NOT_VISIT) {
                    continue;
                }
                
                queue.add(new Characters(nx, ny));
                dist[nx][ny] = dist[poll.x][poll.y] + 1;
            }
        }
    }
}

class Characters {
    int x;
    int y;
    
    Characters(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
/*
0,0
n-1, m-1
*/