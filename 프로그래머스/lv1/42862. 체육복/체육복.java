import java.util.Arrays;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int[] arr = new int[n];
        for(int i : lost)
            arr[i-1] = -1;
        for(int i : reserve) {
            if(arr[i-1] == -1) {
                arr[i-1] = 0;
            } else {
                arr[i-1] = 1;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i == 0){
               if(arr[i] == -1 && arr[i + 1] == 1){
                   arr[i] = 0;
                   arr[i + 1] = 0;
               } 
            }else if(i == n -1){
                if(arr[i] == -1 && arr[i - 1] == 1){
                   arr[i] = 0;
                   arr[i - 1] = 0;
               } 
            }else{
                if(arr[i] == -1 && arr[i - 1] == 1){
                   arr[i] = 0;
                   arr[i - 1] = 0;
                }else if(arr[i] == -1 && arr[i + 1] == 1){
                   arr[i] = 0;
                   arr[i + 1] = 0;
                }  
            }
        }
        
        for(int i : arr)
            if(i >= 0) answer ++;
        
        return answer;
    }
}