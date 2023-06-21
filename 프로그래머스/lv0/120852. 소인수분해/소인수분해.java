import java.util.*;

class Solution {
    public int[] solution(int n) {
        String list = "";
        int step = 2;
        
        while(n != 1){
            if(n % step == 0){
                n = n / step;
                if(!list.contains(String.valueOf(step)))
                    list += step + ",";
            } else {
                step++;
            }
        }
        
        String[] list2 = list.split(",");
        int size = list2.length;
        int[] answer = new int[size]; 
        for(int i = 0; i < size; i++){
            answer[i] = Integer.valueOf(list2[i]);
        }
        
        return answer;
    }
}