class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int arraySize = array.length;
        for(int i = 0; i < arraySize; i++){
            if(array[i] == n) answer++;
        }
        return answer;
    }
}