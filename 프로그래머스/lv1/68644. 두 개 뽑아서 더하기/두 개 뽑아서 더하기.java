import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++){
            for(int n = i + 1; n < numbers.length; n++){
                set.add(numbers[i] + numbers[n]);
            }
        }
        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr);
        return arr;
    }
}