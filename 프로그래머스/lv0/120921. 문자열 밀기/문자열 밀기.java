class Solution {
    public int solution(String A, String B) {
        int answer = -1;
        int size = A.length();
        
        for(int i = 0; i < size; i++){
            String step = "";
            
            step = A.substring(size - i)+ A.substring(0, size - i);
            if(step.equals(B)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}