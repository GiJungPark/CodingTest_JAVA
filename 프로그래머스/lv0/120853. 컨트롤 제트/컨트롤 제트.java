class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] list = s.split(" ");
        int size = list.length;
        int step = 0;
        for(int i = 0; i < size; i++){
            if(0 <= i && i < size){
                if(!list[i].equals("Z")){
                    answer += step;
                    step = Integer.valueOf(list[i]);
                } else {
                    step = 0;
                }
                
                if(i == size - 1){
                    if(!list[i].equals("Z")){
                    answer += Integer.valueOf(list[i]);
                    }
                }
            } 
        }
        return answer;
    }
}