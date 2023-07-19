class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int one = 0;
        int two = 0;
        for(int i = 0; i < goal.length; i++){
            if(cards1.length > one && goal[i].equals(cards1[one])){
                one++;
            }else if(cards2.length > two && goal[i].equals(cards2[two])){
                two++;
            }else{
                answer = "No";
                break;
            }
            answer = "Yes";
        }
        return answer;
    }
}