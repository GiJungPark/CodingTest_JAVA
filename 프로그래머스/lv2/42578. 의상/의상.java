import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int size = clothes.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            if(map.get(clothes[i][1]) == null){
                map.put(clothes[i][1], 1);
            }else{
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        
        if(map.size() == 1){
            for(int i : map.values()){
                answer = answer * i;
            }
        } else {
            for(int i : map.values()){
                answer = answer * (i + 1);
            }
            answer--;
        }
        
        return answer;
    }
}