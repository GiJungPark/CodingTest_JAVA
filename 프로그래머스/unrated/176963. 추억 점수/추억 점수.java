// 1. 이름에 맞는 그리움 점수를 가질 해시맵을 생성한다.
// 2. photo배열을 돌며 스코어를 계산한다.

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        //System.out.println(map);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(String str : photo[i]){
                if(map.containsKey(str))
                    score += map.get(str);
            }
            list.add(score);
        }
        //System.out.println(list);
        
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++)
            answer[i] = list.get(i).intValue();
        
        return answer;
    }
}