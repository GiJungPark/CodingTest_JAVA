class Solution {
    public String solution(String X, String Y) {
        StringBuffer sb = new StringBuffer();
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        int[] arr = new int[10];
        
        for(int i = 0; i < X.length(); i++)
            xArr[X.charAt(i) - '0']++;
        for(int i = 0; i < Y.length(); i++)
            yArr[Y.charAt(i) - '0']++;
        for(int i = 0; i < 10; i++)
            arr[i] = xArr[i] > yArr[i] ? yArr[i] : xArr[i];
        
        
        for(int i = 9; i >= 0; i--)
            sb.append(String.valueOf(i).repeat(arr[i]));
        
        String answer = sb.toString();
        
        if(answer.length() == 0){
            answer = "-1";
        }else if(answer.replaceAll("0", "").length() == 0){
            answer = "0";
        }
        
        return answer;
    }
}