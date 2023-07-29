import java.util.Stack;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 0;
        
        int answer = 0;
        String str = s + s;
        int size = s.length();
        for(int i = 0; i < size; i++){
            String step = str.substring(i, i + size);
            int stepNum = 0;
            Stack<Character> stack = new Stack<>();
            for(int k = 0; k < size; k++){
                if(!stack.isEmpty()){
                    if(compare(stack.peek(), step.charAt(k))){
                        stack.pop();
                        stepNum++;
                    }else{
                        stack.push(step.charAt(k));
                    }
                }else{
                    stack.push(step.charAt(k));
                }
            }
            if(stack.size() == 0) answer++;
        }
        return answer;
    }
    
    public boolean compare(Character chr1, Character chr2){
        if(chr1 == '(' && chr2 == ')') return true;
        if(chr1 == '{' && chr2 == '}') return true;
        if(chr1 == '[' && chr2 == ']') return true;
        return false;
    }
}