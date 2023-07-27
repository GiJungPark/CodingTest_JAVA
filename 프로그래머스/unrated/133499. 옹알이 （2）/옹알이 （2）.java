class Solution {
    public int solution(String[] babbling) {
        int size = babbling.length;
        int answer = size;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < size; i++){
            String str = babbling[i];
            boolean chk = true;
            for(String step : arr){
                if(str.contains(step.repeat(2))){
                    answer -= 1;
                    chk = false;
                    break;
                }
            }
            if(chk){
                str = str.replaceAll("aya|ye|woo|ma", "");
                if(str.length() > 0)
                    answer -= 1;    
            }
        }
        return answer;
    }
}