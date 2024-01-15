import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] point = new int[3];
        int idx = -1;
        
        for (int i = 0; i < dartResult.length(); i++) {
            char letter = dartResult.charAt(i);
            
            if (letter == '0') {
                if (i != 0 && dartResult.charAt(i - 1) == '1') {
                    point[idx] = 10;
                } else {
                    idx++;
                }
                continue;
            }
            
            if ((int) letter >= 49 && (int) letter <= 57) { //1에서 9까지의 숫자라면
                idx++;
                point[idx] = Integer.parseInt(String.valueOf(letter));

            } else if (letter == 'S') {
                point[idx] = (int) Math.pow(point[idx], 1);
                
            } else if (letter == 'D') {
                point[idx] = (int) Math.pow(point[idx], 2);
                
            } else if (letter == 'T') {
                point[idx] = (int) Math.pow(point[idx], 3);
                
            } else if (letter == '*') {
                point[idx] *= 2; //해당 점수 2배
                
                if (idx != 0) {
                    point[idx - 1] = point[idx - 1] * 2; //전 점수 2배                  
                }
                                
            } else { //#이라면
                point[idx] = point[idx] * (-1);   
            }
        }
        
        for (int p : point) {
            answer += p;
        }
        return answer;
    }//main
}//class