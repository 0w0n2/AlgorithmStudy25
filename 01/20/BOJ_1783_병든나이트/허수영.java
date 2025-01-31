import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long distance=0;

        if(N==1) distance =1; //못움직임
        else if (N==2) distance=Math.min((M+1)/2,4); //4방향 안됨 고로 최대 거리4 
        else if(3<=N){
            if(M<7) distance= Math.min(M,4); //위랑 같음
            else distance = M-2;
        } //규칙은 그림그려보며 노가다 해야함

        System.out.println(distance);
      }
}
