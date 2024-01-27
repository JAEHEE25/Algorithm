import java.util.*;
class Solution {
    static String[] message = {"님이 들어왔습니다.", "님이 나갔습니다."};
    
    public String[] solution(String[] record) {
        List<String> result = new ArrayList<>();
        List<Integer> commands = new ArrayList<>();
        Map<String, String> idName = new HashMap<>();
        
        for (String rc : record) {
            String[] details = rc.split(" ");
            String command = details[0];
            String id = details[1];
            
            if (command.equals("Leave")) {
                result.add(id);
                commands.add(1);
                continue;
            }

            String name = details[2];
            if (command.equals("Enter")) {
                result.add(id); //id님이 들어왔습니다
                commands.add(0);
                idName.put(id, name); //해시맵에 저장        
            } else { //Change
                idName.put(id, name); //해시맵에 저장
            }

        }
        
        //id 이름으로 변환
        String[] answer = new String[result.size()]; 
        for (int i = 0; i < result.size(); i++) {
            answer[i] = getMessage(idName.get(result.get(i)), commands.get(i));
        }
        return answer;
    }
    
    public String getMessage(String id, int command) {
        return id + message[command];
    }
}