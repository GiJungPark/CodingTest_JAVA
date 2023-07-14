import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int doubleSize = elements.length * 2;
        int size = elements.length;
        Set<Integer> set = new HashSet<>();
        
        //같은 배열을 이어 붙여서 원형처럼 있는 효과를 만듦
        // [7,9,1,1,4] + [7,9,1,1,4]
        int[] arr = new int[doubleSize];
        for(int i = 0; i < doubleSize; i++){
            arr[i] = elements[i % size];
        }
        
        //기존 배열 사이즈 만큼 한바퀴 돔
        //배열 사이즈 만큼의 부분 수를 만들어서 Set에 저장함
        for(int i = 0; i < size; i++){
            int step = 0;
            for(int n = i; n < i + size; n++){
                step = step + arr[n];
                if(set.add(step)) answer++;
            }
        }
        return answer;
    }
}