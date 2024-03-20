class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : s.split(" ", -1)) {
            for (int i = 0; i < str.length(); i++) {
                String letter = String.valueOf(str.charAt(i));
                if (i % 2 == 0) sb.append(letter.toUpperCase());
                else sb.append(letter.toLowerCase());
            }
            sb.append(" ");
        }
        return sb.deleteCharAt(s.length()).toString();
    }
}