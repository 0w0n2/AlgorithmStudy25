import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null; 
		
		// T일까지 계산값을 T+1에 저장 : 출력값=T+1일의 dp
		int[][] day = new int[T+2][2];
		int[] dp = new int[T+2];
		for(int i=1; i<T+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			day[i][0] = t;
			day[i][1] = p;
		}
		 
		int max = -1;
		for(int i=1;i<=T+1;i++) {
			// max에 그날 금액을 저장
			if(max < dp[i]) {
				max = dp[i];
			}
			
			int nxt = i + day[i][0];
			if(nxt < T+2) {
				// day조건에 맞으면 max값을 더해 감
				dp[nxt] = Math.max(dp[nxt], max+day[i][1]);
			}
			 
		}
		System.out.println(dp[T+1]);
	}
}
