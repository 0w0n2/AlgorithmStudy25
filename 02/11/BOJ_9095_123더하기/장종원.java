import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp= new int[12];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < 11; i++) {
            int sum = 0;
            for(int j = i; j > i-4; j--) {   // 점화식 없음
                sum += dp[j];
            }
            dp[i] = sum;
        }

        for(int i = 0 ; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);
        }
    }
}
