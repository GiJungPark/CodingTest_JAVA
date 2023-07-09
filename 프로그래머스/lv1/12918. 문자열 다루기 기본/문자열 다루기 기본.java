class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int size = s.length();
        if(size == 4 || size == 6){
            for(int i = 0; i < size; i++)
                if(s.charAt(i) > '9') answer = false;
        }else{
            answer = false;
        }
        
        
        return answer;
    }
}