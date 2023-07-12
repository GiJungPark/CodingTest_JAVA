import java.util.*;

class Solution {
    public int solution(String s) {
        int size = s.length();
        String str = "";
        String step = "";
        HashMap<String, String> hashMap = hash();
                
        for(int i = 0; i < size; i++){
            char chr = s.charAt(i);
            if('0' <= chr && chr <= '9'){
                str += chr;
            }else{
                step += chr;
                if(hashMap.containsKey(step)){
                    str += hashMap.get(step);
                    step = "";    
                }
            }
        }
        int answer = Integer.valueOf(str);
        return answer;
    }
    
    private static HashMap<String, String> hash(){
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("zero", "0");
        hashmap.put("one", "1");
        hashmap.put("two", "2");
        hashmap.put("three", "3");
        hashmap.put("four", "4");
        hashmap.put("five", "5");
        hashmap.put("six", "6");
        hashmap.put("seven", "7");
        hashmap.put("eight", "8");
        hashmap.put("nine", "9");
        return hashmap;
    }
}