import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); 
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int count = 0;
        int idx = 0;
        int end = 0;
        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                priorityQueue.add(jobs[idx++]);
            }
            
            if(priorityQueue.isEmpty()){
                end = jobs[idx][0];
            }else{
                int[] tmp = priorityQueue.poll();
                answer += tmp[1] - tmp[0] + end;
                end += tmp[1];
                count++;
            }
            
        }
        answer = (int)(answer / count);
        
        return answer;
    }
}