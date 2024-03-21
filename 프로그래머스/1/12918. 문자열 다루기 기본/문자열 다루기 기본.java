class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && isNumeric(s);
    }
    
    public boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!(c >= 48 && c <= 57)) return false;
        }
        return true;
    }
}