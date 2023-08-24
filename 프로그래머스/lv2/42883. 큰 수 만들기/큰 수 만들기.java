import java.util.Stack;

class Solution {
    public String solution(String number, int k) { 
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < number.length(); i++){
            char step = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < step && k-- > 0){
                stack.pop();
            }
            stack.push(step);
        }
        
        while(k-- > 0){
            stack.pop();
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            answer.append(stack.get(i));
        }
        return answer.toString();
    }
}