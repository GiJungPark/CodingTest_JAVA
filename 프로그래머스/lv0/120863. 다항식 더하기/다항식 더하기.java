class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int num = 0;
        int xNum = 0;
        String[] arr = polynomial.split(" ");
        int arrSize = arr.length;
        
        for(int i = 0; i < arrSize; i++){
            String step = arr[i];
            if(step.contains("x")){
                step = step.replace("x", "");
                if(step.equals("")){
                    xNum += 1;
                }else{
                    xNum += Integer.valueOf(step);
                }
            } else if(!step.contains("+")){
                num += Integer.valueOf(step);
            }
        }
        if(xNum != 0){
            if(num != 0){
                if(xNum == 1){
                    answer = "x + " + num;
                } else {
                    answer = xNum + "x + " + num;
                }
            } else {
                if(xNum == 1){
                    answer = "x";
                } else {
                    answer = xNum + "x";
                }
            }
        } else {
            if(num != 0){
                answer = num + "";
            }
        }
        return answer;
    }
}