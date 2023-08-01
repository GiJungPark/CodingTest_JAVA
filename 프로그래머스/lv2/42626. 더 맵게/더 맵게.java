import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int i : scoville)
            heap.add(i);
        
        int min = heap.peek();
        while(min < K && heap.size() > 1){
            answer++;
            int a = heap.poll();
            int b = heap.poll();
            int tmp = a + (b * 2);
            heap.add(tmp);
            min = heap.peek();
        }
        
        if(min < K){
            answer = -1;
        }
        
        return answer;
    }
}