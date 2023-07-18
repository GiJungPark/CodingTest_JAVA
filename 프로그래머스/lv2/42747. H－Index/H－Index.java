import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int size = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i < size; i++){
            if(citations[i] >= size - i){
                answer = size - i;
                break;
            }
        }
        return answer;
    }
}