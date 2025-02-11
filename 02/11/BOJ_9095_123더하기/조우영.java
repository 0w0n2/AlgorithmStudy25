import java.io.*;

public class B_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        // 12 안주면 런타임에러; (문제를 잘 보자)
        int[] dp = new int[12];
				
				// dp[3]일 때 처음 3이 쓰이므로 3까지 추가해야함
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int j = 4; j < N+1; j++) {
            for (int k = 1; k < 4; k++) {
                dp[j] += dp[j-k];
            }
        }
        
        for (int i = 0; i < T; i++) {
            System.out.println(dp[N]);
        }

        br.close();
    }

}
