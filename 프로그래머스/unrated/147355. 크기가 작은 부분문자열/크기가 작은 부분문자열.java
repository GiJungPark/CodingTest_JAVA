class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long numP = Long.valueOf(p);
        int size = p.length();
        int forSize = t.length() - size;
        for(int i = 0; i <= forSize; i++){
            long numT = Long.valueOf(t.substring(i, i + size));
            if(numP >= numT) answer++;
        }
        return answer;
    }
}