class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] 성격유형 = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int size = survey.length;
        int[] 성격점수 = new int[8];
        
        for(int i = 0; i < size; i++){
            String[] 성격 = survey[i].split("");
            int score = choices[i] - 4;
            if(score > 0){
                성격점수[성격변환(성격[1])] += score;
            }else if(score < 0){
                성격점수[성격변환(성격[0])] -= score;
            }
        }
        
        for(int i = 0; i < 8; i += 2){
            if(성격점수[i + 1] > 성격점수[i]){
                answer += 성격유형[i + 1];
            } else {
                answer += 성격유형[i];
            }
        }
        
        return answer;
    }
    
    public int 성격변환(String 성격){
        String[] 성격유형 = {"R", "T", "C", "F", "J", "M", "A", "N"};
        int size = 성격유형.length;
        int answer = 0;
        for(int i = 0; i < size; i++){
            if(성격.equals(성격유형[i])){
                answer = i;
            }
        }
        return answer;
    }
}