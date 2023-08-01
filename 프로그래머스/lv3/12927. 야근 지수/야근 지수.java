import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i : works)
            priorityQueue.offer(i);
        
        while(n > 0 && priorityQueue.size() != 0){
            int tmp = priorityQueue.poll();
            if(tmp != 1)
                priorityQueue.offer(tmp - 1);
            n--;
        }
        
        while(priorityQueue.size() != 0){
            answer += (int)Math.pow(priorityQueue.poll(), 2);
        }
        
        return answer;
    }
}