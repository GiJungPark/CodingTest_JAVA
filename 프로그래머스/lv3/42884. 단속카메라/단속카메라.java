import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        List<Pair> list = new ArrayList<>();
        for(int[] step : routes){
            list.add(new Pair(step[0], step[1]));
        }
        Collections.sort(list);
        
        int size = list.size();
        int start = list.get(0).start;
        int end = list.get(0).end;
        for(int i = 1; i < size; i++){
            Pair pair = list.get(i);
            //System.out.println(pair.start + " " + pair.end);
            if(pair.start > end){
                end = pair.end;
                start = pair.start;
                answer++;
            }else{
                start = pair.start;
            }
        }
        
        return answer;
    }
}

class Pair implements Comparable<Pair>{
    int start;
    int end;
    Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    
    //진입 지점이 빠른 순으로 정렬
    //만일 진입 지점이 동일하다면 진출 지점이 느린 순으로 정렬
    @Override
    public int compareTo(Pair pair){
        return this.end - pair.end;
    }
}