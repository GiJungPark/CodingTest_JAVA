import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int size = arr.length;
        if(size == 1){
            int[] answer = {-1};
            return answer;
        }else{
            int[] answer = op(arr);
            return answer;
        }
    }
    private int[] op(int[] arr){
        int size = arr.length;
        int min = arr[0];
        for(int i = 1; i < size; i++)
            if(min > arr[i]) min = arr[i];
        
        int[] answer = new int[size - 1];
        int count = 0;
        for(int i = 0; i < size; i++){
            int step = arr[i];
            if(min != step) answer[count++] = step;
        }
        return answer;
    }
}