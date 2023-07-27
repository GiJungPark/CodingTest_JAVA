import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet())
            list.add(map.get(key));
        list.sort(Collections.reverseOrder());
        
        int sum = 0;
        for(int i : list){
            answer++;
            sum += i;
            if(sum >= k) break;
        }
        return answer;
    }
}