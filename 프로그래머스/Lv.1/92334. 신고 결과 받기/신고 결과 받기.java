import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> newIdList = Arrays.asList(id_list);
        Map<String, HashSet<String>> info = new HashMap<>();
        
        //초기화
        for (String id : id_list) {
            info.put(id, new HashSet<>());
        }
        
        //신고 기록 저장 - 신고 받은 사람 : 나를 신고한 사람
        for (String data : report) {
            String reporter = data.split(" ")[0];
            String reported = data.split(" ")[1];
            info.get(reported).add(reporter);
        }
    
        //메일 수 구하기
        for (int i = 0; i < id_list.length; i++) {
            if (info.get(id_list[i]).size() >= k) { //정지된 사용자라면
                for (String reporter: info.get(id_list[i])) { //나를 신고한 사람들의 메일 수 추가
                    answer[newIdList.indexOf(reporter)]++;
                }
            }
        }
        
        return answer;
    }
}