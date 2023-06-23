class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        int s1_size = s1.length;
        int s2_size = s2.length;
        
        for(int i = 0; i < s1_size; i++){
            for(int n = 0; n < s2_size; n++){
                if(s1[i].equals(s2[n])) answer++;
            }
        }
        return answer;
    }
}