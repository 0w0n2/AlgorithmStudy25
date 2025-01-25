import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n =Integer.parseInt(br.readLine());
        int i;
        
        for(i=1; i<n; i++){
            n-=i; //n은 i번째 대각선
        }
        if(i%2 == 0){
            System.out.println(n + "/"+ (i-n+1) );
        }
        else{
            System.out.println((i-n+1) + "/" + n);
        }
    }
}
