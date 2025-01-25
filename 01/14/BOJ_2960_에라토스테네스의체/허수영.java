import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        System.out.println(N);
//        System.out.println(K);
        int[] arr = new int[N+1];
        for (int i = 2; i <= N; i++) {
            arr[i] = i;}
//            System.out.println(arr[i]);
        int count = 0;
        for(int i=2; i<=N; i++){
            if (arr[i] !=0) {
                for (int j = i; j<=N; j+=i){
                    if(arr[j] != 0){
                        arr[j]=0;
                        count++;
                        if (count == K){
                            System.out.println(j);
                        }
                    }
                }
            }
        }

      }
    }

