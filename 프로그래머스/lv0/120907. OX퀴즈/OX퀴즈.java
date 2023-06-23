class Solution {
    public String[] solution(String[] quiz) {
        int size = quiz.length;
        String[] answer = new String[size];
        for(int i = 0; i < size; i++){
            String[] list = quiz[i].split(" ");
            int num1 = Integer.valueOf(list[0]);
            int num2 = Integer.valueOf(list[2]);
            int num3 = Integer.valueOf(list[4]);
            if(list[1].equals("+")){
                answer[i] = num1 + num2 == num3 ? "O" : "X";
            } else {
                answer[i] = num1 - num2 == num3 ? "O" : "X";
            }
        }
        return answer;
    }
}