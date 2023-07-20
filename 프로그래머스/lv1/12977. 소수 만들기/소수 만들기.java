import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        
        //HashSet를 사용하여 주어진 범위의 최대 소수까지 저장
        Set<Integer> set = new HashSet<>();
        int size = nums.length;
        int max = nums[size - 1] + nums[size - 2] + nums[size - 3];
        int primeArrSize = max + 1;
        int[] primeArr = new int[primeArrSize];
        
        //에라스토테네스의 체를 사용하여 소수 판별 및 저장
        for(int i = 2; i < primeArrSize; i++){
            primeArr[i] = i;
        }
        for(int i = 2; i < primeArrSize; i++){
            if(primeArr[i] != 0) set.add(primeArr[i]);
            
            for(int k = 1; k * i < primeArrSize; k++){
                primeArr[i * k] = 0;
            }
        }
        
        //3중 for문을 사용하여 범위의 모든 값을 확인
        for(int i = 0; i < size - 2; i++){
            for(int k = i + 1; k < size - 1; k++){
                for(int j = k + 1; j < size; j++){
                    if(set.contains(nums[i] + nums[k] + nums[j]))
                        answer++;
                }
            }
        }

        return answer;
    }
}