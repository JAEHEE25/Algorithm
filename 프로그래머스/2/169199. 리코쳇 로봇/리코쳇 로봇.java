import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int nx;
    static int ny;
    static int answer = -1;
    
    public int solution(String[] board) {
        char[][] boardArr = new char[board.length][board[0].length()];
        for (int i = 0 ; i < board.length; i++) {
            boardArr[i] = board[i].toCharArray();
        }
        
        visit = new boolean[board.length][board[0].length()];
        for (int i = 0; i < boardArr.length; i++) {
            for (int j = 0; j < boardArr[0].length; j++) {
                if (boardArr[i][j] == 'R') {
                    BFS(i, j, boardArr, visit);
                    return answer;
                }
            }
        }
        return answer;
    }
    
    public void BFS(int rx, int ry, char[][] boardArr, boolean[][] visit) {
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(rx, ry, 0));
        visit[rx][ry] = true;
        
        while (!queue.isEmpty()) {
            Robot poll = queue.poll();
            
            if (boardArr[poll.x][poll.y] == 'G') {
                answer = poll.count;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                nx = poll.x;
                ny = poll.y;
                getMove(poll.x, poll.y, i, boardArr); //nx, ny 업데이트
                
                if (!visit[nx][ny]) {
                    queue.add(new Robot(nx, ny, poll.count + 1));
                    visit[nx][ny] = true;
                }
            }
        }
    }
    
    public void getMove(int x, int y, int i, char[][] boardArr) {
        int xdir = dx[i];
        int ydir = dy[i];
        
        int tx = x;
        int ty = y;
        
        while (true) {
            tx += xdir;
            ty += ydir;

            //장애물/가장자리 만나면
            if (tx < 0 || tx >= boardArr.length || ty < 0
                || ty >= boardArr[0].length || boardArr[tx][ty] == 'D') {
                break;
            }
            
            nx = tx;
            ny = ty;
        }
            
        

    }
}

class Robot {
    int x;
    int y;
    int count;
    
    public Robot(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}