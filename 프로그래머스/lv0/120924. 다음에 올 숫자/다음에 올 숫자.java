class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int size = common.length;
        int difStep = 0;
        double ratStep = 0;
        
        //등차와 등비 데이터 쌓기
        for(int i = 0; i < size - 1; i++){
            difStep += common[i + 1] - common[i];
            if(common[i] != 0 &&common[i + 1] != 0){
                ratStep += (double)common[i + 1] / common[i];
            }
        }
        
        //원소 개수로 나누어 등차인지 확인
        int testDif = (int)((double)difStep / (size - 1));
        int testDif2 = common[1] - common[0];
        if(testDif == testDif2){
            answer = common[size - 1] + testDif2;
        }
        
        //원소 개수로 나누어 등비인지 확인
        double testRat = ((double)ratStep / (size - 1));
        double testRat2 = (double)common[1] / common[0];
        if(testRat == testRat2){
            answer = (int)(common[size - 1] * testRat2);
        }
        
        return answer;
    }
}