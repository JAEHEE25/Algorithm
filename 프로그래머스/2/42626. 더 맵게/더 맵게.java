import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int s : scoville) {
            queue.add(s);
        }
        
        while (queue.peek() < K) {
            if (queue.size() < 2) {
                answer = -1;
                break;
            }
            queue.offer(queue.poll() + (queue.poll() * 2));
            answer++;
        }
        return answer;
    }
}
