class Solution {
    public int solution(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = (res[i-1] + res[i-2]) % 1234567;
        }
        return res[n];
    }
}