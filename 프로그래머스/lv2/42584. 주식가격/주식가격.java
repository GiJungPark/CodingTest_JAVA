import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

class Pair{
        int price;
        int time;
        Pair(int price, int time){
            this.price = price;
            this.time = time;
        }
        
    }

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            Pair pair = new Pair(prices[i], i);
            if(stack.empty()){
                stack.push(pair);
            }else{
                Pair step = stack.peek();
                while(!stack.empty() && step.price > pair.price){
                    step = stack.pop();
                    answer[step.time] = pair.time - step.time;
                    if(stack.empty()) break;
                    step = stack.peek();
                }
                stack.push(pair);
            }
        }
        
        while(!stack.empty()){
            Pair step = stack.pop();
            answer[step.time] = prices.length - 1 - step.time;
        }
        
        return answer;
    }
}