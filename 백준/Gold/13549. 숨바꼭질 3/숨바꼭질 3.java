import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int subin;
    static int sister;
    static Queue<Place> queue;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;
    static int max = 100000;


    public static void main(String[] args) throws IOException {
//        String pack = Main.class.getPackage().toString().split(" ")[1];
//        String realPack = pack.split("[.]")[1] + "/" + pack.split("[.]")[2];
//        BufferedReader br = new BufferedReader(new FileReader(realPack + "/input.txt"));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        subin = Integer.parseInt(st.nextToken());
//        sister = Integer.parseInt(st.nextToken());


        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        sister = sc.nextInt();

        visit = new boolean[max + 1];
        BFS();
        System.out.println(answer);

    }//main

    static void BFS() {
        queue = new LinkedList<>();
        queue.add(new Place(subin, 0));
        
        while (!queue.isEmpty()) {
            Place poll = queue.poll();
            visit[poll.place] = true;

            if (poll.place == sister) {
                answer = Math.min(answer, poll.time);
            }

            int plusOne = poll.place + 1;
            int minusOne = poll.place - 1;
            int mulTwo = poll.place * 2;
            check(mulTwo, poll, 0);
            check(plusOne, poll, 1);
            check(minusOne, poll, 1);

        }
    }

    static void check(int value, Place poll, int addTime) {
        if (value >= 0 && value <= 100000 && !visit[value]) {
            queue.add(new Place(value, poll.time + addTime));
        }
    }
}//class

class Place {
    int place;
    int time;

    Place(int place, int time) {
        this.place = place;
        this.time = time;
    }
}
