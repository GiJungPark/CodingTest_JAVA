class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        int size = db.length;
        
        for(int i = 0; i < size; i++){
            if(id_pw[0].equals(db[i][0]))
                if(id_pw[1].equals(db[i][1])){
                    answer = "login";
                }else{
                    answer = "wrong pw";
                }
        }
        
        return answer;
    }
}