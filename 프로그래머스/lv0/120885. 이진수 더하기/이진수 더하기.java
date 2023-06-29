class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        answer = decToBin((binToDec(bin1) + binToDec(bin2)));
        
        return answer;
    }
    
    public int binToDec(String str){
        int size = str.length();
        int counter = 0;
        int answer = 0;
        for(int i = size - 1; i >= 0; i--){
            int step = Integer.valueOf(str.charAt(i) - '0');
            answer += step * (int)Math.pow(2, counter);
            counter++;
        }
        
        return answer;
    }
    
    public String decToBin(int num){
        String step = "";
        String answer = "";
        
        if(num == 0){
            answer = "0";
        } else {
            while(num > 0){
                step += num % 2 + "";
                num /= 2;
            }
        
            int size = step.length();
            for(int i = size - 1; i >= 0; i--){
                answer += step.charAt(i);
            }   
        }
        
        return answer;
    }
}