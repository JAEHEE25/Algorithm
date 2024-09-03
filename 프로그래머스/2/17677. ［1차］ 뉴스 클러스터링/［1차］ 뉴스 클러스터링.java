import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        
        //문자열 구하기
        List<String> list1 = getResult(str1);
        List<String> list2 = getResult(str2);
        
        //각 문자열의 개수 구하기
        Map<String, Integer> map1 = getCount(list1);
        Map<String, Integer> map2 = getCount(list2);
        
        int x = 0; //교
        int u = 0; //합
        
        for (String s1 : map1.keySet()) {
            System.out.println(s1);
            int count1 = map1.get(s1);
            if (map2.keySet().contains(s1)) {
                int count2 = map2.get(s1);
                x += Math.min(count1, count2);
                u += Math.max(count1, count2);
                map2.keySet().remove(s1);
            } else {
                u += count1;
            }
        }
        
        for (String s2 : map2.keySet()) {
            int count2 = map2.get(s2);
            u += count2;
        }
        
        //유사도
        if (x == 0 && u == 0) {
            answer = 1;
        } else {
            answer = (double) x / (double) u;
        }
        
        return (int) (answer * 65536);
    }
    
    public boolean validate(char c) {
        int i = (int) c;
        if (c >= 65 && c <= 90) return true;
        return false;
    }
    
    public List<String> getResult(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            String result = str.substring(i, i+2).toUpperCase(); //대문자로
            if (validate(result.charAt(0)) && validate(result.charAt(1))) {
                list.add(result);
            }
        } 
        return list;
    }
    
    public Map<String, Integer> getCount(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : list) {
            int count = (int) list.stream().filter(s -> s.equals(str)).count();
            map.put(str, count);
        }
        return map;
    }
}

/*
두 집합의 교집합 크기 / 두 집합의 합집합 크기
- 둘 다 공집합이면 1

1. 두 글자씩 끊기 (영문자만 들어있어야함, 대소문자 통일)
2. 교집합 개수 구하기
3. 합집합 개수 구하기
4. 유사도 구하기
교: 최소 개수, 합: 최대 개수 반영해서 계산
*/