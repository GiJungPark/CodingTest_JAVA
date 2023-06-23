class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] list = my_string.split(" ");
        int size = list.length;
        int num1 = Integer.valueOf(list[0]);
        int num2 = Integer.valueOf(list[2]);
        
        switch(list[1]){
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
        }
        
        if(size > 3){
            for(int i = 3; i < size; i += 2){
                int num = Integer.valueOf(list[i+1]);
                switch(list[i]){
                    case "+":
                        answer += num;
                        break;
                    case "-":
                        answer -= num;
                        break;
                }
            }
        }
        
        return answer;
    }
}