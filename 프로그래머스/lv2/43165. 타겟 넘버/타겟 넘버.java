import java.util.*;

class Number {
    int num;
    int idx;
    
    public Number(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}


class Solution {
    public int solution(int[] numbers, int target) {
        int answer = BFS(0, 0, numbers, target);
        
        return answer;
    }//main
    
    static int BFS(int start, int idx, int[] numbers, int target) {
        Queue<Number> queue = new LinkedList<>();
        int answer = 0;
        
        queue.add(new Number(start, idx));
        
        while (!queue.isEmpty()) {
            Number poll = queue.poll();
                       
            if (poll.idx == numbers.length) {
                if (poll.num == target){
                    answer++;
                }
                continue;
            }
            
            queue.add(new Number(poll.num + numbers[poll.idx], poll.idx + 1));
            queue.add(new Number(poll.num - numbers[poll.idx], poll.idx + 1));
        }
        
        return answer;
        
    }//BFS
    
    /*
    answer = 0
    
    BFS (int start, int idx) ->
    큐.add(new Number(start, idx))  //numbers[0], 1

    while !큐.isEmpty
        poll
        
        if (poll.num == 정답)
            answer++
            return
        
        큐.add(new Number(poll.num + numbers[poll.idx], poll.idx+1)
        큐.add(new Number(poll.num - numbers[poll.idx], poll.idx+1)   
    */
    
    
}//class