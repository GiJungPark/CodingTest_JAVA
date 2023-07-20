//https://nous-temperature.tistory.com/705 참조
//세기 숫자 6, 연도 숫자 6
class Solution {
    public String solution(int a, int b) {
        //월 배열 생성 및 월 숫자
        int[] arr = {0,-1,2,3,6,1,4,6,2,5,0,3,5};
        int month = arr[a];
        
        //일 숫자
        int day = b % 7;
        
        //요일 배열 생성
        String[] arr2 = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        String answer = arr2[(6+6+month+day)%7];
        
        return answer;
    }
}