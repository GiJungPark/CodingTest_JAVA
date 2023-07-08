class Solution {
    public int[] solution(String s) {
        int count = 0;
        int size = 0;
        int fre = 0;
        while(size != 1){
            size = s.replaceAll("0", "").length();
            count += s.length() - size;
            s = Integer.toString(size, 2);
            fre++;
        }
        int[] answer = {fre, count};
        return answer;
    }
}