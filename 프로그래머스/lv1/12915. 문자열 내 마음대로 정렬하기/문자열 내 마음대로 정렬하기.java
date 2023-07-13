class Solution {
    public String[] solution(String[] strings, int n) {
        int size = strings.length;
        for(int i = 0; i < size - 1; i++){
            for(int k = i + 1; k < size; k++){
                String strOne = strings[i];
                String strTwo = strings[k];
                char charOne = strOne.charAt(n);
                char charTwo = strTwo.charAt(n);
                
                if(charOne > charTwo || 
                   (charOne == charTwo && strOne.compareTo(strTwo) > 0)){
                    String step = strOne;
                    strings[i] = strTwo;
                    strings[k] = step;
                }
            }
        }
        String[] answer = strings;
        return answer;
    }
}