class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int count = 0;
        int step = 0;
        
        if(num % 2 == 0) step = 1;
        int start = (int)(total / num) - ((int)(num / 2) - step);;
        
        for(int i = start; i < start + num; i++){
                answer[count++] = i;
            }
        
        return answer;
    }
}