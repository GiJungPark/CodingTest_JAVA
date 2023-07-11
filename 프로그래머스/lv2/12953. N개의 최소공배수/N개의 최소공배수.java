import java.util.*;

class Solution {
    public int solution(int[] arr) {
        //1. 내림차순으로 배열 정렬
        //2. 최대 공약수를 구하고 최소 공배수를 저장 반복
        int[] arr2 = reverseSort(arr);
        int answer = arr2[0];
        for(int i = 1; i < arr2.length; i++){
            int gcd = gcd(answer, arr2[i]);
            answer = (answer * arr2[i]) / gcd;
        }
        return answer;
    }
    
    //최대공약수를 구하는 함수
    //단 매개변수의 값이 oneNum > twoNum이어야 함
    private int gcd(int oneNum, int twoNum){
        if(twoNum == 0){
            return oneNum;
        }else{
            return gcd(twoNum, oneNum % twoNum);
        }
    }
    
    //배열을 내림차순으로 정렬해주는 함수
    private int[] reverseSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int n = i + 1; n < arr.length; n++){
                if(arr[i] < arr[n]){
                    int step = arr[n];
                    arr[n] = arr[i];
                    arr[i] = step;
                } 
            }
        }
        return arr;
    }
}