import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int size = score.length;
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++){
            priorityQueue.add(score[i]);
            if(priorityQueue.size() > k)
                priorityQueue.poll();
            answer[i] = priorityQueue.peek();
        }
        
        return answer;
    }
}