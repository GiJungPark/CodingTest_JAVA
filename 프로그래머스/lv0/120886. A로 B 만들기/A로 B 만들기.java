class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        String[] str1Array = before.split("");
        String[] str2Array = after.split("");
        int size = str1Array.length;
        
        for(int i = 0; i < size; i++){
            for(int n = 0; n < size; n++){
                if(str1Array[i].equals(str2Array[n])) {
                    str2Array[n] = "1";
                    break;
                }
            }
        }
        
        boolean check = true;
        for(int i = 0; i < size; i++){
            if(!str2Array[i].equals("1")) check = false;
        }
        if(check) answer = 1;
        return answer;
    }
}