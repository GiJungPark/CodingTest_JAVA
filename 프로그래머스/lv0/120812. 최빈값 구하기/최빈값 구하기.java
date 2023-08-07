class Solution {
    public int solution(int[] array) {
        int[] list = new int[1000];
        int answer = 0;
        int max = 0;
        boolean check = false;
        
        for(int i = 0; i < array.length; i++){
            list[array[i]] += 1;
        }
        
        for(int i = 0; i < list.length; i++){
            if(list[i] > max){
                max = list[i];
                answer = i;
                check = false;
            }else if(list[i] == max){
                check = true;
            }
        }
        if(check) answer = -1;
        return answer;
    }
}