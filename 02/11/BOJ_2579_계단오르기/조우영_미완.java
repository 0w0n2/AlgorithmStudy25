import java.io.*;
import java.util.*;

public class B_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int[] dp = new int[301];
        int[] stair = new int[T+1];
        for (int i = 1; i <= T; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(dp[2], dp[1]+stair[3]);
        for (int i=4; i<=T; i++) {
		        // 계단 마지막은 밟기, stair[T]가 포함된 경우들만 포함
            if(i==T){
                dp[i] = Math.max(dp[i-2]+stair[i], dp[i-3]+stair[i-1]+stair[i]);
            }
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+stair[i]), dp[i-3]+stair[i-1]+stair[i]);
        }

        System.out.println(dp[T]);

        br.close();
    }

}
