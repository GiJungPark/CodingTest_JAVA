//J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의
//집합 A, B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 1로 정의
//두 글자씩 끊어서 다중집합의 원소로 만듦
//영문 이외의 글자가 포함된 원소는 버림
//대소문자 무시
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < str1.length() - 1; i++){
            String str = str1.substring(i, i + 2);
            if(str.matches("[A-Z][A-Z]")) map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for(int i = 0; i < str2.length() - 1; i++){
            String str = str2.substring(i, i + 2);
            if(str.matches("[A-Z][A-Z]")) map2.put(str, map2.getOrDefault(str, 0) + 1);  
        }
        System.out.println(map1);
        System.out.println(map2);
        List<String> uniList = new ArrayList<>();
        List<String> interList = new ArrayList<>();
        
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key), map2.get(key));
                int max = Math.max(map1.get(key), map2.get(key));
                for(int i = 0; i < min; i++){
                    interList.add(key);
                }
                for(int i = 0; i < max; i++){
                    uniList.add(key);
                }
            }else{
                for(int i = 0; i < map1.get(key); i++){
                    uniList.add(key);
                }
            }
        }
        
        for(String key : map2.keySet()){
            if(!map1.containsKey(key))
                for(int i = 0; i < map2.get(key); i++)
                    uniList.add(key);
        }
        int union = uniList.size();
        int inter = interList.size();
        System.out.println(union);
        System.out.println(inter);
        
        if(union == 0 && inter == 0) return 65536;
        if(union == 0 && inter > 0) return 0;
        
        
        answer = (int)(((float)inter / union) * 65536);
        
        return answer;
    }
}