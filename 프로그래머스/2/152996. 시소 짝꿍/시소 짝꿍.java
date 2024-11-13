import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double,Integer> map = new HashMap<>();
        for(int w : weights){
            double a = (double)w;
    		double b = ((double)w*2.0)/3.0;
    		double c = (double)w/2.0;
    		double d = ((double)w*3.0)/4.0;
            answer += map.getOrDefault(a, 0);
            answer += map.getOrDefault(b, 0);
            answer += map.getOrDefault(c, 0);
            answer += map.getOrDefault(d, 0);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return answer;
    }
}