//String 클래스의 + 연산은 느리기 때문에
//StringBuffer를 사용하였음

class Solution {
    public String solution(int[] food) {
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i < food.length; i++){
            int step = (int)(food[i] / 2);
            for(int k = 0; k < step; k++){
                sb.append(i);
            }
        }
        String answer = sb.toString() + 0 + sb.reverse().toString();
        return answer;
    }
}