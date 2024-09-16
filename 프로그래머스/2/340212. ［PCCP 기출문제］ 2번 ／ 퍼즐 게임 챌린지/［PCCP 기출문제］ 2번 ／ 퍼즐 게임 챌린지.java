class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        //레벨 가능한 범위 -> 최솟값 ~ 최댓값
        int left = 1;
        int right = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            right = Math.max(right, diffs[i]);
        }
        
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            // System.out.println("mid = " + mid);
            
            long time = getTime(diffs, mid, times); //걸리는 시간
            if (time > limit) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public long getTime(int[] diffs, int level, int[] times) {
        long time = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                int error = diffs[i] - level;
                time += + (times[i] + times[i-1]) * error;
                time += times[i];
            }
        }
        // System.out.println("time " + time);
        return time;
    }
}