class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int count = 0;
        int step = (int)(total / num);
        if(num % 2 == 0){
            int start = step - ((int)(num / 2) - 1);
            for(int i = start; i < start + num; i++){
                answer[count++] = i;
            }
        }else{
            int start = step - (int)(num / 2);
            for(int i = start; i < start + num; i++){
                answer[count++] = i;
            }
        }
        return answer;
    }
}