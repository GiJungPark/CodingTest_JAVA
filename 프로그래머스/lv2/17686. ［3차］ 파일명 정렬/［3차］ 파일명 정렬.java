import java.util.ArrayList;
import java.util.Collections;
class Solution {
    private static ArrayList<Data> list = new ArrayList<>();
    
    public String[] solution(String[] files) {
        int size = files.length;
        int index = 0;
        for(String s : files){
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            boolean flag = false;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if('0' <= c && c <= '9'){
                    number.append(c);
                    flag = true;
                }else{
                    if(!flag){
                        head.append(c);
                    }else{
                        tail.append(s.substring(i));
                        break;
                    }
                }
            }
            list.add(new Data(index++, head.toString(), number.toString(), tail.toString()));
            //System.out.println(index-1+ " " + head+ "   " + number+ " "+ tail);
        }
        Collections.sort(list);
        size = list.size();
        String[] answer = new String[size];
        for(int i = 0; i < size; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(i).head);
            sb.append(list.get(i).number);
            sb.append(list.get(i).tail);
            answer[i] = sb.toString();
        }
        return answer;
    }
    private static class Data implements Comparable<Data>{
        int idx;
        String head;
        String number;
        String tail;
        
        public Data(int idx, String head, String number, String tail){
            this.idx = idx;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        @Override
        public int compareTo(Data data) {
            if(this.head.equalsIgnoreCase(data.head)){
                if(Integer.parseInt(this.number) == Integer.parseInt(data.number)){
                    return this.idx - data.idx;
                }
                return Integer.parseInt(this.number) - Integer.parseInt(data.number);
            }
            return this.head.toLowerCase().compareTo(data.head.toLowerCase());
        }
    }
}