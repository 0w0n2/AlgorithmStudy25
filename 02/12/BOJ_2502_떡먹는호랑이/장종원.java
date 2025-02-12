import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result1 = 0;
        int result2 = 0;

        for (int A = 1; A <= K / 2; A++) {
            for (int B = A; B <= K; B++) {
                int[] dp = new int[D + 1];
                dp[1] = A;
                dp[2] = B;

                for (int i = 3; i <= D; i++) {
                //점화식
                    dp[i] = dp[i - 1] + dp[i - 2];
                }

                if (dp[D] == K) {
                    result1 = A;
                    result2 = B;
                    break;
                }
            }
            if (result1 != 0) break;
        }

        System.out.println(result1);
        System.out.println(result2);
    }
}

