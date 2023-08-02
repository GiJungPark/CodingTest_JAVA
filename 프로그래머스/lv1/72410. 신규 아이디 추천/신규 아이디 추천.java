class Solution {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();
        //2단계
        new_id = new_id.replaceAll("[^0-9a-z-_.]","");
        //3단계
        new_id = new_id.replaceAll("\\.{2,}", ".");
        //4단계
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        //5단계
        if(new_id.equals(""))
            new_id = "a";
        //6단계
        if(new_id.length() >= 16){
            if(new_id.charAt(14) == '.'){
                new_id = new_id.substring(0, 14);
            }else{
                new_id = new_id.substring(0, 15);
            }   
        }
        //7단계
        if(new_id.length() <= 2){
            char step = new_id.charAt(new_id.length() - 1);
            while(new_id.length() < 3){
               new_id = new_id + step;
            }
        }
        //System.out.println(new_id);
        String answer = new_id;
        return answer;
    }
}