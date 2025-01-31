import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long price=0;
        long six_min=1000; //1000보다 작거나 같으므로
        long one_min=1000;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int six_price = Integer.parseInt(st.nextToken());
            int one_price = Integer.parseInt(st.nextToken());

            if(six_price<six_min) six_min=six_price; //6개중 최솟값
            if(one_price<one_min) one_min=one_price; //1개중 최솟값
        }
         if(one_min *6<six_min) price= N*one_min; //1개가격 6개가 6개가격보다 싸면 1개를 N개 곱함
         else{
             price=Math.min(((N/6) * six_min)+(one_min * (N%6)), (N/6 +1)*six_min);
         } //그게 아니면 식이 아주 직관적임
         System.out.println(price);
      }
}
