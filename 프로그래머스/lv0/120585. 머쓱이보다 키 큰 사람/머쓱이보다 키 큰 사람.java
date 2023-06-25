class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        int arraySize = array.length;
        
        for(int i = 0; i < arraySize; i++){
            if(array[i] > height) answer++;
        }
        
        return answer;
    }
}