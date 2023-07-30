import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        for(String str : record){
            String [] step = str.split(" ");
            //추가 or 이름 변경 해시맵에 저장
            if(step[0].equals("Enter") || step[0].equals("Change"))
                map.put(step[1], step[2]);
        }
        
        for(String str : record){
            String [] step = str.split(" ");
            //추가
            if(step[0].equals("Enter")){
                list.add(map.get(step[1]) + "님이 들어왔습니다.");
            //떠남
            }else if(step[0].equals("Leave")){
                list.add(map.get(step[1]) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}