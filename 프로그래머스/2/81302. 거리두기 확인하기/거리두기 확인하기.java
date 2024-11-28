class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int p = 0; p < 5; p++) {
            char[][] seats = new char[5][5];
            for (int i = 0; i < 5; i++) {
                seats[i] = places[p][i].toCharArray();
            }
            if (solution(seats)) answer[p] = 1;
        }
        return answer;
    }
    
    boolean solution(char[][] seats) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (seats[i][j] == 'P') {
                    if (!checkDist(seats, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    boolean checkDist(char[][] seats, int x, int y) {
        //상하좌우 1칸, 상하좌우 2칸, 대각선
        int[] dx = {0, 0, 1, -1, -2, 2, 0, 0, -1, -1, 1, 1};
        int[] dy = {1, -1, 0, 0, 0, 0, -2, 2, -1, 1, -1, 1};
        
        for (int i = 0; i < 12; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            
            if (seats[nx][ny] == 'P') { //응시자
                if (i < 4) { //상하좌우 1칸
                    return false;
                } else if (i < 8) { //상하좌우 2칸
                    if (!checkPartitionBy2(seats, dx[i], dy[i], x, y)) { //파티션 위치 체크
                        return false;
                    }
                } else { //대각선
                    if (!checkPartitionByDiag(seats, dx[i], dy[i], x, y)) { //파티션 위치 체크
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    boolean checkPartitionBy2(char[][] seats, int dx, int dy, int nx, int ny) {
        if (dx == -2 && dy == 0) { //위2
            if (seats[nx - 1][ny] == 'X') {
                return true;
            }
        } else if (dx == 2 && dy == 0) { //아래2
            if (seats[nx + 1][ny] == 'X') {
                return true;
            }   
        } else if (dx == 0 && dy == -2) { //왼2
            if (seats[nx][ny - 1] == 'X') {
                return true;
            }    
        } else { //오2
            if (seats[nx][ny + 1] == 'X') {
                return true;
            }    
        }
        return false;
    }
    
    boolean checkPartitionByDiag(char[][] seats, int dx, int dy, int nx, int ny) {
        if (dx == -1 && dy == -1) { //왼쪽 위
            if (seats[nx - 1][ny] == 'X' && seats[nx][ny - 1] == 'X') {
                return true;
            }
        } else if (dx == -1 && dy == 1) { //오른쪽 위
            if (seats[nx - 1][ny] == 'X' && seats[nx][ny + 1] == 'X') {
                return true;
            }   
        } else if (dx == 1 && dy == -1) { //왼쪽 아래
            if (seats[nx + 1][ny] == 'X' && seats[nx][ny - 1] == 'X') {
                return true;
            }    
        } else { //오른쪽 아래
            if (seats[nx + 1][ny] == 'X' && seats[nx][ny + 1] == 'X') {
                return true;
            }    
        }
        return false;
    }    
}