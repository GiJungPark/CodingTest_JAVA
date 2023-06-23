class Solution {
    public int[] solution(int[] array) {
        int size = array.length;
        int max = 0;
        int index = 0;
        for(int i = 0; i < size; i++){
            int step = array[i];
            if(max < step) {
                max = step;
                index = i;
            }
        }
        int[] answer = {max, index};
        return answer;
    }
}