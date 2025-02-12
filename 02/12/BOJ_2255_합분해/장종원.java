import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int MOD = 1000000000;

        int[][] dp = new int[M + 1][N + 1]; // 정수 나누는 개수 1~M개 경우 , 총합 0~N되는 경우 DP

        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= M; i++) {
            dp[i][0] = 1;
        }

        for (int k = 2; k <= M; k++) {
            for (int n = 1; n <= N; n++) {
                //점화식
                dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % MOD;
            }
        }
        System.out.println(dp[M][N]);
    }
}

