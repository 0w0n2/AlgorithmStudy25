import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if(L==0 && P==0 && V==0)
                break;
            int result=(V/P)*L +(V%P<L ? V%P:L); //더 작은넘 선택해서 더해
            
            System.out.println("Case "+i+": "+result);
            i++;
        
        }
    }
}
