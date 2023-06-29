class Solution {
    public int solution(int chicken) {
        int answer = 0;
        answer = operator(chicken);
        
        return answer;
    }
    
    public int operator(int num){
        if(num < 10) return 0;
        int serviceChicken = num / 10;;
        int coupon = num % 10;
        return serviceChicken + operator(serviceChicken + coupon);
    }
}