class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int count = 0;
        for(String i : skill_trees){
            String step = i.replaceAll("[^"+skill+"]","");
            
            int counter = 0;
            int size = step.length();
            for(int j = 0; j < size; j++){
                if(step.charAt(j) == skill.charAt(j)){
                    counter++;
                }else{
                    break;
                }
            }
            if(counter == size) count++;
        }
        answer = count;
        return answer;
    }
}