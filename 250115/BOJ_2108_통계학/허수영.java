import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        double sum=0;
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(br.readLine());
            sum+=arr[i];
        }
        double mean=Math.round(sum/n);
        System.out.println(mean); //평균
        
---------------------/최빈값은 ㅈㅅ...구현 불가판단.. -------------
        Arrays.sort(arr);
        int median=arr[n/2];
        System.out.println(median);//중앙
        
        
        System.out.println(arr[n-1]-arr[0]);//범위
    }
}
