import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int size = commands.length;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size; i++){
            int num1 = commands[i][0];
            int num2 = commands[i][1];
            int count = 0;
            
            int[] arr = new int[num2 - num1 + 1];
            for(int n = num1 - 1; n < num2; n++){
                arr[count++] = array[n];
            }
            
            Arrays.sort(arr);
            list.add(arr[commands[i][2] - 1]);
        }
        
        int list_size = list.size();
        int[] answer = new int[list_size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i).intValue();
        }
        
        return answer;
    }
}