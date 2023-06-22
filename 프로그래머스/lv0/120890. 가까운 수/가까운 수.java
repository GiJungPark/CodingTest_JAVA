import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int max = 100;
        int size = array.length;
        Arrays.sort(array);
        for(int i = 0; i < size; i++){
            if(max > Math.abs(n - array[i])){
                max = Math.abs(n - array[i]);
                answer = array[i];
            }
        }
        return answer;
    }
}