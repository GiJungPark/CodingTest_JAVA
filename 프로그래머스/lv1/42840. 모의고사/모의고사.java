import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int size = answers.length;
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int arr1Answer = 0;
        int arr2Answer = 0;
        int arr3Answer = 0;
        
        for(int i = 0; i < size; i++){
            if(answers[i] == arr1[i % 5]) arr1Answer++;
            if(answers[i] == arr2[i % 8]) arr2Answer++;
            if(answers[i] == arr3[i % 10]) arr3Answer++;
        }
        
        List<Integer> list = new ArrayList<>();
        int[] answerArr = {arr1Answer, arr2Answer, arr3Answer};
        Arrays.sort(answerArr);
        if(arr1Answer == answerArr[answerArr.length - 1]) list.add(1);
        if(arr2Answer == answerArr[answerArr.length - 1]) list.add(2);
        if(arr3Answer == answerArr[answerArr.length - 1]) list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}