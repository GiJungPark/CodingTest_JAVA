class Solution {
    public int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            numlist[i] = numlist[i] - n;
        }
        
        for(int i = 0; i < size - 1; i++){
            for(int k = i + 1; k < size; k++){
                int step = 0;
                if(Math.abs(numlist[i]) > Math.abs(numlist[k])){
                    step = numlist[i];
                    numlist[i] = numlist[k];
                    numlist[k] = step;
                } else if(Math.abs(numlist[i]) == Math.abs(numlist[k])){
                    if(numlist[i] < numlist[k]){
                        step = numlist[i];
                        numlist[i] = numlist[k];
                        numlist[k] = step;
                    }
                }
            }
        }
        
        for(int i = 0; i < size; i++){
            answer[i] = numlist[i] + n;
        }
        
        return answer;
    }
}