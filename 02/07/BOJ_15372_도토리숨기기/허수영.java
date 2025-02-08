import java.io.*;
import java.util.*;

public class Main_2110 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());

        int box[]=new int[N+1];

        for(int i=0; i<K; i++){
            st=new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            for(int j=x; j<=y;j+=z){
                if(j>N) break;
                box[j]++;
            }
        }
        int count=0;
        for(int i=1; i<=N;i++){
            count += box[i];
            if(count>=D){
                System.out.println(i);
                break;
             }
        }
    }
}

