import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rope[] = new int[n]; //로프 생성
        int max=0;
        for (int i=0; i<n;i++){
            rope[i] = Integer.parseInt(br.readLine()); //얼마나 듬?
            
        }
        Arrays.sort(rope);
        for(int i=0; i<n;i++){
             max = Math.max(max,rope[i] * (n-i)); //하중 *개수-> 최대하중
        }
        System.out.println(max);
    }
}
