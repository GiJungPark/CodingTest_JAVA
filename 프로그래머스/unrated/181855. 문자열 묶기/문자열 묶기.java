class Solution {
    public int solution(String[] strArr) {
        int[] list = new int[31];
        int answer = 0;
        int step = 0;
        int strArrSize = strArr.length;
        int listSize = list.length;
        for(int i = 0; i < strArrSize; i++){
            list[strArr[i].length()] += 1;
        }
        
        for(int i = 1; i < listSize; i++){
            if(list[i] >= step){
                step = list[i];
            }
        }
        return step;
    }
}