class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long pl = Long.parseLong(p);
        int plen = p.length();
        
        for (int i = 0; i <= t.length() - plen; i++) {
            String str = t.substring(i, i + plen);
            if (pl >= Long.valueOf(str)) {
                answer++;
            }
        }
        return answer;
    }
}