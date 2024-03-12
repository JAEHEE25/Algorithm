class Solution {
    public long solution(int a, int b) {
        if (a > b) {
            return getAnswer(a, b);
        } else if (a < b) {
            return getAnswer(b, a);
        } else {
            return a;
        }
    }
    
    public long getAnswer(int high, int low) {
        long result = 0;
        for (int n = low; n <= high; n++) {
            result += n;
        }
        return result;
    }
}