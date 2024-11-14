class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = Integer.MAX_VALUE;
        
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                answer[0] = i;
                answer[1] = i;
                return answer;
            }
        }
        
        int left = 0;
        int right = 1;
        long sum = sequence[left] + sequence[right];
        while (right < sequence.length) {
            if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                sum += right < sequence.length ? sequence[right] : 0;
            } else {
                int dist = right - left;
                if (dist < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                } else if (dist == answer[1] - answer[0]) {
                    if (left < answer[0]) {
                        answer[0] = left;
                        answer[1] = right;
                    }
                }
                sum -= sequence[left];
                left++;
            }
        }
        return answer;
    }
}