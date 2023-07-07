class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = Integer.valueOf(arr[0]);
        int max = min;
        for(int i = 1; i < arr.length; i++){
            int step = Integer.valueOf(arr[i]);
            if(step < min){
                min = step;
            }else if(step > max){
                max = step;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}