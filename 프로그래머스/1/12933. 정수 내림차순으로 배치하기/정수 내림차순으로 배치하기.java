class Solution {
    public long solution(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            result.append(getMax(sb));
        }
        
        return Long.parseLong(result.toString());
    }
    
    public int getMax(StringBuilder sb) {
        int max = 0;
        int idx = 0;
        String sbstr = sb.toString();
        for (int i = 0; i < sbstr.length(); i++) {
            int num = Integer.parseInt(String.valueOf(sbstr.charAt(i)));
            if (max < num) {
                max = num;
                idx = i;
            }
        }
        sb.deleteCharAt(idx);
        return max;    
    }
}