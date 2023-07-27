class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = dfs(dungeons, new boolean[dungeons.length], k, 0, 0);
        return answer;
    }
    public int dfs(int[][] dungeons, boolean[] flags, int tried, int maxCnt, int cnt){
        int max = maxCnt;
        for(int i = 0; i < dungeons.length; i++){
            if(flags[i] == false && tried >= dungeons[i][0]){
                System.out.println(i);
                flags[i] = true;
                max = dfs(dungeons, flags, tried - dungeons[i][1], max, cnt + 1);
                flags[i] = false;
            }
        }
        return(Math.max(max, cnt));
    }
}