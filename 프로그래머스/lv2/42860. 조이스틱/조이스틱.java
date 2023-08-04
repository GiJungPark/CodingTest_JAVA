//알파벳 변경으로 인한 최솟값은 비교적 쉽게 계산이 가능함
//문제는 좌우 움직임
// 1. 오른쪽으로만 직진
// 2. 'A'를 제외하는 문자가 나올때 까지 오른쪽으로 갔다가 왼쪽 진행
// 3. 'A'를 제외하는 문자가 나올때 까지 왼쪽으로 갔다가 오른쪽 진행

class Solution {
    public int solution(String name) {
        int answer = 0;
        int size = name.length();
        int move = size - 1;
        
        for(int i = 0; i < size; i++){
            char step = name.charAt(i);
            int idx = i + 1;
            if(step != 'A')
                answer += step - 'A' < 'Z' - step + 1 ? step - 'A' : 'Z' - step + 1;
            
            while(idx < size && name.charAt(idx) == 'A') idx++;
                move = Math.min(move, i * 2 + size - idx);
                move = Math.min(move, (size - idx) * 2 + i);
            
        }
        
        answer += move;
        return answer;
    }
}