class Solution {
    public int solution(int n) {
        int answer = 0;
        int n1Cnt = getBinary1Cnt(n);
        int num = n + 1;

        while (answer == 0) {
            int num1Cnt = getBinary1Cnt(num);
            if (n1Cnt != num1Cnt) answer = 0;
            else answer = num;
            
            num++;
        }
        
        return answer;
    }
    
    public int getBinary1Cnt(int number) {
        int cnt = 0;        
        while (number > 0) {
            if (number % 2 == 1) cnt++;
            number /= 2;
        }        
        return cnt;
    }
}
