package dp; #이거 떄문에 오뜸
import java.io.*;
import java.util.*;
public class backjoon_1463 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x= Integer.parseInt(br.readLine());
        int dp[]=new int[x+1];
        for(int i=2;i<=x;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }

        }
        System.out.println(dp[x]);


    }
}

