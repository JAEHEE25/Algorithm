//14:15
class Solution {
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String new_id) {
        lv1and2(new_id);
        lv3();
        lv4();
        lv5();
        lv6();
        lv7();
        return sb.toString();
    }
    
    void lv1and2(String new_id) {
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println("2 = " + sb);
    }
    
    void lv3() {
        String result = sb.toString().replace("..", ".");
        while (result.contains("..")) {
            result = result.replace("..", ".");
        }
        sb = new StringBuilder(result);
    }
    
    void lv4() {
        String result = sb.toString();
        if (result.equals(".")) {
            sb.deleteCharAt(0);
            return;
        }
        
        if (result.startsWith(".")) {
            sb.deleteCharAt(0);
        }
        
        if (result.endsWith(".")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println("4 = " + sb);
    }
    
    void lv5() {
        String result = sb.toString();
        if (result.isEmpty()) {
            sb.append("a");
        }
        System.out.println("5 = " + sb);
    }
    
    void lv6() {
        if (sb.length() >= 16) {
            String result = sb.toString();
            result = result.substring(0, 15);
            sb = new StringBuilder(result);
            if (result.endsWith(".")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        System.out.println("6 = " + sb);
    }
    
    void lv7() {
        if (sb.length() >= 1 && sb.length() <= 2) {
            char c = sb.charAt(sb.length() - 1);
            while (sb.length() < 3) {
                sb.append(String.valueOf(c));
            }
        }
        System.out.println("7 = " + sb);
    }
    

    
}