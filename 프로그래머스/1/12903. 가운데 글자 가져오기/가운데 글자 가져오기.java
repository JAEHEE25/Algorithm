class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        char[] arr = s.toCharArray();
        if (len % 2 != 0) {
            answer = String.valueOf(s.charAt(len / 2));
        } else {
            answer = s.charAt(len / 2 - 1) + "" + s.charAt(len / 2);
        }
        return answer;
    }
}