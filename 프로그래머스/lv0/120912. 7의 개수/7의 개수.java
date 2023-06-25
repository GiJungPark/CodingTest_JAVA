class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int size = array.length;
        
        for(int i = 0; i < size; i++){
            while(array[i] > 0){
                int step = array[i] % 10;
                if(step != 0 &&step % 7 == 0) answer += 1;
                array[i] = array[i] / 10;
            }
        }
        
        return answer;
    }
}