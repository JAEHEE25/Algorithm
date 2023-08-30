import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        boolean[] isAnswer = new boolean[privacies.length];
                               
        HashMap<String, Integer>  termMap = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            String type = arr[0];
            int num = Integer.parseInt(arr[1]);
            termMap.put(type, num);
        }
        
        String[] todayArr = today.split("[.]");        
      
        for (int i = 0; i < privacies.length; i++) {
            String[] infoArr = privacies[i].split(" ");
            String date = infoArr[0];
            String type = infoArr[1];
            String result = expire(date, type, termMap);
            String[] resultArr = result.split("[.]");        
            
            for (int j = 0; j < 3; j++) {
                int r = Integer.parseInt(resultArr[j]);
                int t = Integer.parseInt(todayArr[j]);
                
                if (r > t) {
                    break;
                } else if (r < t) {
                    isAnswer[i] = true;
                    break;
                }
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < isAnswer.length; i++) {
            if (isAnswer[i]) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }//main
    
    static String expire(String date, String type, HashMap<String, Integer> termMap) {
        int termMonth = termMap.get(type);
        String[] dateArr = date.split("[.]");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        int y;
        int m;
        int d;
        
        if (month + termMonth > 12) {
            y = year + (month + termMonth) / 12;
            m = (month + termMonth) % 12;
            
            if (m == 0) {
                y--;
                m = 12; 
            }
        } else {
            y = year;
            m = month + termMonth;
        }
        
        if (day == 1) {
            m--;
            d = 28;
        } else {
            d = day - 1;
        }
        
        if (d == 0) {
            d = 28;
            m--;
        }
        
        if (m == 0) {
            m = 12;
            y--;
        }

        
        return y + "." + m + "." + d;
    }//expire
}//class