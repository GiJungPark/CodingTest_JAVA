class Solution {
    public String solution(String s) {
        int num = 26;
        int size = s.length();
        int[] numList = new int[num];
        String answer = "";
        
        for(int i = 0; i < size; i++){
            int step = (s.charAt(i) - 'a');
            numList[step] += 1;
        }
        
        for(int i = 0; i < num; i++){
            if(numList[i] == 1){
                answer += (char)('a' + i) + "";
            }
        }
        return answer;
    }
}