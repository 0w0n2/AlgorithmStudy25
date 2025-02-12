import java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [][] dp = new int[31][2];
		dp[3][0] = dp[3][1] = dp[4][0] = 1;
		dp[4][1] = 2; // 3일차 (1, 1), 4일차 (1, 2) 
		for (int i=5; i<=d; i++) { // 바텀업
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}

		for (int i=1; i<k; i++) {  // 방정식 해 구하기
			if ((k-dp[d][0]*i)%dp[d][1] == 0) {
				System.out.printf("%d\n%d", i, (k-dp[d][0]*i)/dp[d][1]);
				return;
			}
		}
		
	}
}

