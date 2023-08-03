import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuffer sb = new StringBuffer();
        String[] arr = new String[numbers.length];
        
        //1. Int를 String으로 변환
        for(int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);
        
        //2. 정렬하기 => 두 개 문자의 순서에 따른 값의 변화를 기준으로
        //[10, 6] => 610, 106 => [6, 10]
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        //3. 정렬된 문자열을 StringBuffer로 다 합하기
        for(String str : arr)
            sb.append(str);
        
        String answer = sb.toString();
        if(answer.replaceAll("0", "").length() == 0) answer = "0";
        return answer;
    }
    
}