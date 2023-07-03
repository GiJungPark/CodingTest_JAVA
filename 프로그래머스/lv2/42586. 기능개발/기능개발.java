import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        int count = 1;
        
        // 소요되는 일자 정리
        for(int i = 0; i < progresses.length; i++){
            int step = 100 - progresses[i];
            int speed = speeds[i];
            if(step % speed != 0){
                list.add((int)(step / speed) + 1);
            } else {
                list.add((int)(step / speed));
            }
        }
        
        //첫 번째를 최대값으로 두고 리스트를 순회
        //최대값보다 작은 값은 카운트를 더함
        //최대값보다 큰 값을 발견하면 기존 카운트를 저장하고 다시 셈
        //마지막 최대값은 순회 종료 후 카운트를 더함 
        int max = list.get(0).intValue();
        for(int i = 1; i < list.size(); i++){
            if(max >= list.get(i).intValue()){
                count++;
            } else {
                max = list.get(i).intValue();
                answerList.add(count);
                count = 1;
            }
        }
        answerList.add(count);
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i).intValue();
        }
        
        return answer;
    }
}