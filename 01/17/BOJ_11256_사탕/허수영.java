import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); //테스트 몇번
        
      for(int i=0; i<T; i++){
         StringTokenizer st = new StringTokenizer(br.readLine());

        int J =Integer.parseInt(st.nextToken()); //사탕
        int N = Integer.parseInt(st.nextToken()); //상자
          
          int[] box = new int[N];
          for(int j=0; j<N;j++){
              st= new StringTokenizer(br.readLine());
              
              int R = Integer.parseInt(st.nextToken()); //가로
              int C = Integer.parseInt(st.nextToken()); //세로
              
              box[j]=R*C; //넓이
          }
          Arrays.sort(box);
          int index =N-1;
          while(J>0 && index >=0){ 
              J -=box[index--]; //사탕개수 - 용량큰넘
          }
          System.out.println(J<=0 ? (N-1-index) : -1);
          
          
           
          
        
      }  
        
        
    }
}
