import java.util.*;

class Solution {
    static int answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int px = 0;
    static int py = 0;
    static List<Place> placeList = new ArrayList<>();
    
    public int solution(String dirs) {
        answer = dirs.length();
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int command = 0;
            if (c == 'U') command = 0;
            else if (c == 'D') command = 1;
            else if (c == 'R') command = 2;
            else command = 3;
            
            int nx = px + dx[command];
            int ny = py + dy[command];
        
            if (nx < -5 || ny < -5 || nx > 5 || ny > 5) {
                answer--;
                continue; //범위 벗어나면 무시
            }
            
            Place newPlace = new Place(px, py, nx, ny); //생성
            check(newPlace); //이미 가본 길인지 검사
            placeList.add(newPlace); //리스트에 추가
            px = nx; //플레이어 위치 이동
            py = ny; //플레이어 위치 이동
        }
        
        return answer;
    }
    
    public void check(Place newPlace) {
        //리스트에 있는지
        for (Place p : placeList) {
            if (newPlace.isSame(p)) {
                answer--;
                break;
            }
        }
    }
}

class Place {
    int prevX;
    int prevY;
    int nowX;
    int nowY;
    
    public Place(int prevX, int prevY, int nowX, int nowY) {
        this.prevX = prevX;
        this.prevY = prevY;
        this.nowX = nowX;
        this.nowY = nowY;
    }
    
    public boolean isSame(Place a) {
        if (this.prevX == a.prevX && this.prevY == a.prevY && this.nowX == a.nowX && this.nowY == a.nowY) {
            return true;
        } else if (this.prevX == a.nowX && this.prevY == a.nowY && this.nowX == a.prevX && this.nowY == a.prevY) {
            return true;
        }
        return false;
    }
}