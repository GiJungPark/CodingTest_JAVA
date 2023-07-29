import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i = 0; i < operations.length; i++){
            String[] step = operations[i].split(" ");
            //값 삽입
            if(step[0].equals("I")){
                ll.add(Integer.valueOf(step[1]));
                Collections.sort(ll);
            //최댓값 or 최솟값 삭제
            }else if (ll.size() > 0){
                if(step[1].equals("1")){
                    ll.removeLast();
                }else{
                    ll.removeFirst();
                }
            }
        }
        
        int a = 0;
        int b = 0;
        if(ll.size() == 1){
            a = ll.get(0).intValue();
        }else if (ll.size() >= 2){
            a = ll.get(ll.size() - 1).intValue();
            b = ll.get(0).intValue();
        }
        int[] answer = {a, b};
        return answer;
    }
}