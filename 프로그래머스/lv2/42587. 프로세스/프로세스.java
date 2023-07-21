import java.util.*;

class Pair{
    int pr;
    int loc;
        
    Pair(int pr, int loc){
        this.pr = pr;
        this.loc = loc;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        int answer = 0;
        int size = priorities.length;
        
        for(int i = 0; i < size ; i++){
            queue.add(new Pair(priorities[i], i));
            list.add(priorities[i]);
        }
        
        list.sort(Comparator.reverseOrder());
        int max = list.get(0);
        
        int count = 1;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.pr == max){
                if(location == pair.loc){
                    answer = count;
                    break;
                }else{
                    count++;
                    list.remove(0);
                    list.sort(Comparator.reverseOrder());
                    max = list.get(0);
                }
            }else{
                queue.add(pair);
            }
        }
        
        return answer;
    }
}