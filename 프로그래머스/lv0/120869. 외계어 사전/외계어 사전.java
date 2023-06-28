class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        boolean check = true;
    
        for(int i = 0; i < dic.length; i++){
            for(int n = 0; n < spell.length; n++){
                if(!dic[i].contains(spell[n])) check = false;
                dic[i] = dic[i].replace(spell[n], "1");
            }
            if(spell.length == dic[i].length() - 
               dic[i].replace("1", "").length() && check)
                answer = 1;
            check = true;
        }
        
        return answer;
    }
}