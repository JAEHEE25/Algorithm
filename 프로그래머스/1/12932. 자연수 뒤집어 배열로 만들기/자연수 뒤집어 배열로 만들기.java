class Solution {
    public int[] solution(long n) {
        String nstr = String.valueOf(n);
        int[] answer = new int[nstr.length()];
        int j = 0;
        for (int i = nstr.length() - 1; i >= 0; i--) {
            answer[j] = Integer.parseInt(String.valueOf(nstr.charAt(i)));
            j++;
        }
        return answer;
    }
}