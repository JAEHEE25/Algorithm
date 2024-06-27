import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Balloon> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder answer = new StringBuilder();
        int killIdx = 0;
        int value;

        while (list.size() != 1) {
            value = list.get(killIdx).getValue(); //터뜨릴 풍선 값 저장
            answer.append(list.get(killIdx).getNum()).append(" "); //정답 기록
            list.remove(killIdx); //터뜨리기

            if (value > 0) value--; //양수일 경우 한 칸 이미 이동
            killIdx += value; //풍선 이동
            killIdx %= list.size();

            if (killIdx < 0) killIdx += list.size();
        }

        answer.append(list.get(0).getNum());
        System.out.println(answer);
    }//main
}//class

class Balloon {
    public int num;
    public int value;

    public Balloon(int num, int value) {
        this.num = num;
        this.value = value;
    }

    public int getNum() {
        return num;
    }

    public int getValue() {
        return value;
    }
}
