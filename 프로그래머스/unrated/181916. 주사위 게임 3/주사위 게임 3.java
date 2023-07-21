import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        
        HashSet<Integer> op = new HashSet<>();
        for(int i : arr) op.add(i);
        
        switch(op.size()){
            case 1:// 모두 같을 때
                return 1111 * a;
                
            case 2:// 같은 숫자 2개 2/2 or 3/1
                if(arr[0]==arr[1] && arr[2]==arr[3]) {
                    return (arr[0] + arr[3]) * Math.abs(arr[0] - arr[3]);
                } else {
                    if(arr[0]==arr[1]){
                        return (10 * arr[0] + arr[3]) * (10 * arr[0] + arr[3]);
                    } else {
                        return (10 * arr[3] + arr[0]) * (10 * arr[3] + arr[0]);
                    }
                }
                    
            case 3:// 2개가 같고 2개는 다름 2/1/1
                if(arr[0] == arr[1]){
                    return arr[2] * arr[3];
                } else if(arr[1] == arr[2]){
                    return arr[0] * arr[3];
                } else {
                    return arr[0] * arr[1];
                }
            case 4:// 1/1/1/1
                return arr[0];
        }
        return 0;
    }
}