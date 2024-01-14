import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            map[i] = toBinaryArray(n, arr1[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int[] result = toBinaryArray(n, arr2[i]);
            for (int j = 0; j < n; j++) {
                if (result[j] == 1) {
                    map[i][j] = 1;
                }
            }
        }
         
        for (int i = 0; i < n; i++) {
            String row = "";
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    row += "#";
                } else {
                    row += " ";
                }
            }
            answer[i] = row;
        }
        return answer;
    }//main
    
    public int[] toBinaryArray(int n, int num) {
        int[] result = new int[n];
        int idx = n - 1;
        
        while (idx >= 0 && num >= 0) {
            result[idx] = num % 2;
            num /= 2;
            idx--;
        }
        return result;
    }
}//class

/*
이진수 변환해서 배열에 저장
다음 이진수 변환해서 배열에 1 갱신
#, 공백 문자열로 변환해서 출력

9
/2 = 4 ...1
/2 = 2 ...0
/2 = 1 ...0
/2 = 0 ...1

28
= 14 ...0
= 7 ...0
= 3 ...1
= 1 ...1
= 0 ...1
*/