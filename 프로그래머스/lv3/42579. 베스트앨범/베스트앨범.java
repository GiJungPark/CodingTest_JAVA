import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int size = genres.length;
        
        //장르별 총 조회수를 저장하는 해시맵 생성
        HashMap<String, Integer> genrePlaysMap = new HashMap<>();
        for(int i = 0; i < size; i++){
            if(genrePlaysMap.containsKey(genres[i])){
                genrePlaysMap.put(genres[i], genrePlaysMap.get(genres[i]) + plays[i]);
            }else{
                genrePlaysMap.put(genres[i], plays[i]);
            }
        }
        
        //해시맵은 순서가 없기 때문에 링크드 리스트로 변환하여 Entry 인터페이스를 사용하여 정렬
        //역순으로 정렬하기 위한 Collections.reverseOrder를 사용하기 위하여 Collections.sort를 사용
        List<Map.Entry<String, Integer>> genresList = new LinkedList<>(genrePlaysMap.entrySet());
        Collections.sort(genresList, Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        //위와 동일한 방법으로 고유번호가 키이고, 재생수가 값인 해시맵을 생성하고 값 기준으로 정렬
        HashMap<Integer, Integer> playsMap = new HashMap<>();
        for(int i = 0; i < size; i++)
            playsMap.put(i, plays[i]);
        
        List<Map.Entry<Integer, Integer>> playList = new LinkedList<>(playsMap.entrySet());
        Collections.sort(playList, Collections.reverseOrder(Map.Entry.comparingByValue()));
        
        //정답을 저장할 리스트 생성
        List<Integer> answerList = new ArrayList<>(); 
        //장르별 총 조회수가 내림차순으로 정렬된 리스트를 순회한다.
        //각 장르에서 노래별 조회수가 내림차순으로 정렬된 리스트를 순회한다.
        //해당 장르에 속하는지 고유번호를 사용하여 확인하며, 2곡이 저장되면 반복을 빠져나온다.
        for(Map.Entry<String, Integer> genre : genresList){
            int count = 0;
            for(Map.Entry<Integer, Integer> play : playList){
                if(genre.getKey().equals(genres[play.getKey()])){
                    answerList.add(play.getKey());
                    count++;
                }
                if(count == 2) break;
            }
        }
        
        int answerSize = answerList.size();
        int[] answer = new int[answerSize];
        for(int i = 0; i < answerSize; i++){
            answer[i] = answerList.get(i).intValue();
        }
        
        return answer;
    }
}