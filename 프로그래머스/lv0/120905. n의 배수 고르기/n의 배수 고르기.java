import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int size = numlist.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            int step = numlist[i];
            if(step % n == 0) list.add(step);
        }
        
        int list_size = list.size();
        int[] answer = new int[list_size];
        for(int i = 0; i < list_size; i++){
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}