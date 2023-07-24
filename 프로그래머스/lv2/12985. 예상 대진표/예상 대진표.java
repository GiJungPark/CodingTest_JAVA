//n명이 참가하는 토너먼트이다.
//a와 b는 서로 만나기 전까지 항시 이긴다.
//a와 b는 몇 라운드에서 만나는가?
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while(Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0){
            a = op(a);
            b = op(b);
            answer++;
        }
        
        return answer;
    }
    
    public int op(int num){
        if(num % 2 == 0){
            return num / 2;
        }else{
            return (num + 1) / 2;
        }
    }
}