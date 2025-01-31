import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int max_weight =  Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max_weight = Math.max(max_weight, arr[i] * (n - i) ); // 가장 적게 견디는 무게 x 로프갯수 -> 로프 줄여도되니 하나씩 줄이며 같은 과정 반복
        }
        System.out.println(max_weight);
    }
}
