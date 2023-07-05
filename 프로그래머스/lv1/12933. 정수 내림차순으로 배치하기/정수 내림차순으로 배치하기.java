class Solution {
    public long solution(long n) {
        //1. 숫자를 문자열로 변경
        //2. 문자열을 숫자 배열로 변경
        String str = String.valueOf(n);
        int strSize = str.length();
        int[] arr = new int[strSize];
        for(int i = 0; i < strSize; i++){
            arr[i] = (str.charAt(i) - '0');
        }
        
        //3. 배열 정렬
        int arrSize = arr.length;
        for(int j = 0; j < arrSize - 1; j++){
            for(int k = j + 1; k < arrSize; k++){
                if(arr[j] > arr[k]){
                    int step = arr[j];
                    arr[j] = arr[k];
                    arr[k] = step;
                }
            }
        }
        
        //4. 배열 숫자로 변경
        long answer = 0;
        for(int i = 0; i < arrSize; i++){
            answer += arr[i] * (long)Math.pow(10, i);
        }
        
        return answer;
    }
}