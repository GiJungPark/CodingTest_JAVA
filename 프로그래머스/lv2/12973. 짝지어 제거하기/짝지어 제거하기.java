import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        if(s.length() % 2 != 0) return 0;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                    stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        
        int answer = stack.isEmpty() ? 1: 0;
        return answer;
    }
}