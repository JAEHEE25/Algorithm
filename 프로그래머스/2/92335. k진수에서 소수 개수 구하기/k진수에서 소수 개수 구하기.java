import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        ArrayList<Long> numbers = toPrime(n, k); //소수 변환

        //답 구하기
        int N = numbers.size();
        for (int i = 0; i < N; i++) {
            if (isPrime(numbers.get(i))) {
                if (N == 1) {
                    answer = 1;
                    break;
                }
                answer++;   
            }
        }
        return answer;
    }
    
    public ArrayList<Long> toPrime(int n, int k) { //소수 변환
        String result = "";
        while (n > 0) {
            result += n % k;
            n /= k;
        }
        char[] cArr = new char[result.length()];
        int idx = 0;
        for (int i = result.length() - 1; i >= 0; i--) {
            cArr[i] = result.charAt(idx);
            idx++;
        }
        
        ArrayList<Long> numbers = new ArrayList<>();
        for (String r : String.valueOf(cArr).split("0")) {
            if (!r.isBlank()) {
                numbers.add(Long.parseLong(r));
            }
        }
        return numbers;
    }
    
    public boolean isPrime(long num) { //소수인지 판별
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
