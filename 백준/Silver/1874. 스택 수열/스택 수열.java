import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        //입력받은 배열 생성
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        
        Stack<Integer> st = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;
        
        for(int su : arr){
            if(su >= num){
                while(su >= num){
                    st.push(num++);
                    bf.append("+\n");
                }
                st.pop();
                bf.append("-\n");
            }else{
                int n = st.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}