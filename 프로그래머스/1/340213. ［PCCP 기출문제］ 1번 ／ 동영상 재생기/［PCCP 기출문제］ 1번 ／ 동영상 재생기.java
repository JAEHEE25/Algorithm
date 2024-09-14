class Solution {
    static int now = 0;
    static int video = 0;
    static int opstart = 0;
    static int opend = 0;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        video = getValue(video_len);
        now = getValue(pos);
        opstart = getValue(op_start);
        opend = getValue(op_end);
        
        for (String command : commands) {
            opening();
            if (command.equals("prev")) {
                prev();
            } else {
                next();
            }
        }
        opening();
        
        int mv = now / 60;
        int sv = now % 60;
        
        String mm = format(mv);
        String ss = format(sv);
        
        return mm + ":" + ss;
    }
    
    String format(int v) {
        if (0 <= v && v <= 9) { //한자리수
            return "0" + v;
        }
        return String.valueOf(v);
    }
    
    int getValue(String str) {
        String[] arr = str.split(":");
        int v1 = Integer.valueOf(arr[0]);
        int v2 = Integer.valueOf(arr[1]);
        return 60 * v1 + v2;
    }

    void prev() { //10초 전
        now -= 10;
        if (now < 0) now = 0;
    }
    
    void next() { //10초 후
        now += 10;
        if (now > video) now = video;
    }
    
    void opening() {
        if (now >= opstart && now <= opend) {
            now = opend;
        }
    }
}