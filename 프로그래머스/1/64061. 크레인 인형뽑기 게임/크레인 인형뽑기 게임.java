import java.util.*;

class Solution {
    static int answer = 0;
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        
        for (int move : moves) {
            pick(move, board, stack);
        }
        
        return answer;
    }
    
    public void pick(int move, int[][] board, Stack<Integer> stack) {
        for (int i = 0; i < board.length; i++) {
            int picked = board[i][move - 1];
            if (picked != 0) {
                if (!stack.isEmpty() && stack.peek() == picked) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(picked);
                }
                board[i][move - 1] = 0;
                return;
            }
        }
    }
}