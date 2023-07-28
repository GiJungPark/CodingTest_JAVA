import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {        
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < cities.length; i++){
            //cacheSize가 0인 경우
            if(cacheSize == 0){
                answer += 5;
                continue;
            }
            String step = cities[i].toUpperCase();
            //cache hit 발생 => 실행시간 +1초
            if(queue.contains(step)){
                queue.remove(step);
                queue.offer(step);
                answer++;
            //cache miss 발생 => 실행시간 +5초
            }else{
                if(queue.size() == cacheSize) queue.poll();
                queue.offer(step);
                answer += 5;
            }
        }
        return answer;
    }
}