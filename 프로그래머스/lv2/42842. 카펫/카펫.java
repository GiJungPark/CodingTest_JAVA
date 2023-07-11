// 가로 x 세로 = yellow (단 가로가 세로보다 더 길거나 같다.)
// 가로 x 2 + 세로 x 2 + 4(모서리) = brown 총합

//brown + yellow = 세로 x 가로 ?

class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 1;
        while(true){
            if(yellow % height == 0){
                width = yellow / height;
                if((width * 2) + (height * 2) == brown - 4) break;
            }
            height++;
        }
        int[] answer = {width + 2, height + 2};
        return answer;
    }
}