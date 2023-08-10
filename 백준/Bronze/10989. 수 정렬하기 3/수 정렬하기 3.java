import java.io.*;

public class Main {
    public static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        
        radix_sort(A, 5);

        for(int i : A){
            bw.write(i + "\n");
        }
        
        bw.flush();
        bw.close();
    }

    public static void radix_sort(int[] A, int max_size){
        int size = A.length;
        int jarisu = 1;
        int count = 0;
        int[] tmp = new int[size];

        while(count < max_size) {
            int[] bucket = new int[10];
            for (int i = 0; i < size; i++) {
                bucket[(A[i] / jarisu) % 10]++;
            }

            for(int i = 1; i < 10; i++){
                bucket[i] += bucket[i-1];
            }

            for(int i = size-1; i >= 0; i--){
                tmp[bucket[(A[i] / jarisu) % 10] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            for(int i = 0; i < size; i++){
                A[i] = tmp[i];
            }

            jarisu = jarisu * 10;
            count++;
        }
    }
}